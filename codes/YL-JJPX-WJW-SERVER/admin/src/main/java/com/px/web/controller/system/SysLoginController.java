package com.px.web.controller.system;

import com.px.common.constant.Constants;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.core.domain.entity.SysMenu;
import com.px.common.core.domain.entity.SysUser;
import com.px.common.core.domain.model.LoginBody;
import com.px.common.core.domain.model.LoginUser;
import com.px.common.exception.ServiceException;
import com.px.common.exception.user.UserPasswordNotMatchException;
import com.px.common.utils.*;
import com.px.common.utils.sign.Md5Utils;
import com.px.framework.manager.AsyncManager;
import com.px.framework.manager.factory.AsyncFactory;
import com.px.framework.security.context.AuthenticationContextHolder;
import com.px.framework.web.service.SysLoginService;
import com.px.framework.web.service.SysPermissionService;
import com.px.framework.web.service.TokenService;
import com.px.system.domain.MessageRequest;
import com.px.system.domain.ResetPasswordRequest;
import com.px.system.domain.UserTestTask;
import com.px.system.mapper.SysUserMapper;
import com.px.system.service.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 登录验证
 *
 * @author 品讯科技
 */
@RestController
public class SysLoginController extends BaseController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SendMessageService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private MissionService missionService;


    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);

        return ajax;
    }

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/noPassLoginPost")
    public AjaxResult noPassLoginPost(@RequestBody LoginBody loginBody) throws Exception {
        AjaxResult ajax = success();
        if (StringUtils.isBlank(loginBody.getNickName())) {
            throw new ServiceException("姓名不能为空！");
        }
        if (StringUtils.isBlank(loginBody.getPhoneNumber())) {
            throw new ServiceException("手机号不能为空！");
        }

        // 验证码校验
        //loginService.validateCaptcha(loginBody.getUsername(), loginBody.getCode(), loginBody.getUuid());

        SysUser querySysUser = new SysUser();
        querySysUser.setNickName(RsaUtils.decryptByPrivateKey(loginBody.getNickName()));
        querySysUser.setPhonenumber(RsaUtils.decryptByPrivateKey(loginBody.getPhoneNumber()));
        //querySysUser.setStatus("0");
        List<SysUser> sysUsers = sysUserMapper.selectUserList(querySysUser);

        if (sysUsers != null && !sysUsers.isEmpty()) {
            SysUser sysUser = sysUsers.get(0);
            Authentication authentication = null;
            try {
                //直接不用springsecurity 认证、自己构造出数据 TODO 这里对于除了admin以外的用户角色列表是否需要遍历逗号分割拼接暂未测试
                UserDetails userDetails = new LoginUser(sysUser.getUserId(), sysUser.getDeptId(), sysUser, permissionService.getMenuPermission(sysUser));
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                        AuthorityUtils.createAuthorityList("ROLE_USER"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                if (e instanceof BadCredentialsException) {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                    throw new UserPasswordNotMatchException();
                } else {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, e.getMessage()));
                    throw new ServiceException(e.getMessage());
                }
            } finally {
                AuthenticationContextHolder.clearContext();
            }
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            loginService.recordLoginInfo(loginUser.getUserId());
            ajax.put(Constants.TOKEN, tokenService.createToken(loginUser));
        }
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return success(menuService.buildMenus(menus));
    }


    /**
     * 手机端现场考试验证方法
     */
    @PostMapping("/sceneLoginPost")
    public AjaxResult sceneLoginPost(@RequestBody LoginBody loginBody) {
        if (StringUtils.isBlank(loginBody.getNickName())) {
            throw new ServiceException("姓名不能为空！");
        }
        if (StringUtils.isBlank(loginBody.getPhoneNumber())) {
            throw new ServiceException("手机号不能为空！");
        }
        if (StringUtils.isBlank(loginBody.getCode())) {
            throw new ServiceException("验证码不能为空！");
        }

        // 验证码校验
        loginService.validateCaptcha(loginBody.getUsername(), loginBody.getCode(), loginBody.getUuid());

        SysUser querySysUser = new SysUser();
        querySysUser.setNickName(loginBody.getNickName());
        querySysUser.setPhonenumber(loginBody.getPhoneNumber());
        querySysUser.setStatus("0");
        List<SysUser> sysUsers = sysUserMapper.selectUserList(querySysUser);

        if (sysUsers != null && sysUsers.size() > 0) {
            SysUser sysUser = sysUsers.get(0);
            Authentication authentication = null;
            try {
                //直接不用springsecurity 认证、自己构造出数据 TODO 这里对于除了admin以外的用户角色列表是否需要遍历逗号分割拼接暂未测试
                UserDetails userDetails = new LoginUser(sysUser.getUserId(), sysUser.getDeptId(), sysUser, permissionService.getMenuPermission(sysUser));
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                        AuthorityUtils.createAuthorityList("ROLE_USER"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                if (e instanceof BadCredentialsException) {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                    throw new UserPasswordNotMatchException();
                } else {
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, e.getMessage()));
                    throw new ServiceException(e.getMessage());
                }
            } finally {
                AuthenticationContextHolder.clearContext();
            }

            AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            loginService.recordLoginInfo(loginUser.getUserId());

            String token = tokenService.createToken(loginUser);

            AjaxResult ajax = success();
            ajax.put(Constants.TOKEN, token);


            ajax.put("newTest", 1);
            UserTestTask userTestTaskQuery = new UserTestTask();
            userTestTaskQuery.setPhone(loginBody.getPhoneNumber());
            userTestTaskQuery.setTaskId(loginBody.getTaskId());
            List<UserTestTask> userTestTaskList = missionService.getUserTestList(userTestTaskQuery);
            if (!CollectionUtils.isEmpty(userTestTaskList)) {
                UserTestTask userTestTask = userTestTaskList.get(0);
                if (null != userTestTask.getId()) {
                    ajax.put("newTest", 0);
                }
            }
            return ajax;
        } else {
            return error("用户信息不存在/录入有误，请联系本单位管理员重新录入信息");
        }
    }


    /**
     * 更新/插入现场考试人员信息
     */
    @PostMapping("/addSceneLogin")
    public AjaxResult addSceneLogin(@RequestBody LoginBody loginBody) {
        if (StringUtils.isBlank(loginBody.getNickName())) {
            throw new ServiceException("姓名不能为空！");
        }
        if (StringUtils.isBlank(loginBody.getPhoneNumber())) {
            throw new ServiceException("手机号不能为空！");
        }
        if (loginBody.getDeptId() == null) {
            throw new ServiceException("单位不能为空！");
        }

        SysUser querySysUser = new SysUser();
        querySysUser.setPhonenumber(loginBody.getPhoneNumber());
        List<SysUser> sysUsers = iSysUserService.selectUserList(querySysUser);
        SysUser sysUser = new SysUser();
        if (sysUsers != null && sysUsers.size() > 0) {
            sysUser = sysUsers.get(0);
            sysUser.setNickName(loginBody.getNickName());
            sysUser.setDeptId(loginBody.getDeptId());
            iSysUserService.updateUser(sysUser);
        } else {
            sysUser.setUserName(loginBody.getPhoneNumber());
            sysUser.setDeptId(loginBody.getDeptId());
            sysUser.setPhonenumber(loginBody.getPhoneNumber());
            sysUser.setNickName(loginBody.getNickName());
            sysUser.setDelFlag("0");
            sysUser.setStatus("0");
            sysUser.setTagIds("106");
            String password = configService.selectConfigByKey("sys.user.initPassword");
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            iSysUserService.insertUser(sysUser);
        }


        Authentication authentication = null;
        try {
            //直接不用springsecurity 认证、自己构造出数据 TODO 这里对于除了admin以外的用户角色列表是否需要遍历逗号分割拼接暂未测试
            UserDetails userDetails = new LoginUser(sysUser.getUserId(), sysUser.getDeptId(), sysUser, permissionService.getMenuPermission(sysUser));
            authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    AuthorityUtils.createAuthorityList("ROLE_USER"));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }

        AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        loginService.recordLoginInfo(loginUser.getUserId());

        String token = tokenService.createToken(loginUser);

        AjaxResult ajax = success();
        ajax.put(Constants.TOKEN, token);

        return ajax;
    }

    /**
     * 手机端登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/loginPost")
    public AjaxResult loginPost(@RequestBody LoginBody loginBody) {
        if (StringUtils.isBlank(loginBody.getUsername())) {
            throw new ServiceException("登录手机号不能为空！");
        }
        if (null == loginBody.getLoginType() || loginBody.getLoginType() < 1 || loginBody.getLoginType() > 2) {
            throw new ServiceException("登号方式错误！");

        }
        if (loginBody.getLoginType() == 2 && StringUtils.isBlank(loginBody.getMaskCode())) {
            throw new ServiceException("验证码不能为空！");
        }

        AjaxResult ajax = success();
        // 生成令牌
        String token = loginService.userLogin(loginBody);
        ajax.put(Constants.TOKEN, token);

        if (loginBody.getTaskId() != null && !loginBody.getTaskId().equals("")) {
            ajax.put("newTest", 1);
            UserTestTask userTestTaskQuery = new UserTestTask();
            userTestTaskQuery.setPhone(loginBody.getUsername());
            userTestTaskQuery.setTaskId(loginBody.getTaskId());
            List<UserTestTask> userTestTaskList = missionService.getUserTestList(userTestTaskQuery);
            if (!CollectionUtils.isEmpty(userTestTaskList)) {
                UserTestTask userTestTask = userTestTaskList.get(0);
                if (null != userTestTask.getId()) {
                    ajax.put("newTest", 0);
                }
            }
        }


        return ajax;
    }

//
//    @ApiOperation("退出接口")
//    @PostMapping(value = "/logoutPost")
//    public AjaxResult logoutPost(@ApiIgnore HttpServletResponse response) {
//        LoginUser loginUser = SecurityUtils.getLoginUser();
//        SysUser user = loginUser.getUser();
//        String userName = user.getUserName();
//        return success("退出成功");
//    }


    @ApiOperation("塞入验证码")
    @PostMapping(value = "/setVercode")
    public AjaxResult setVercode(@RequestBody String vercode) {
        byte[] decodedBytes = Base64.getDecoder().decode(vercode);
        // 将字节转换成字符串
        String vercodeuuid = new String(decodedBytes);
        String[] vercodeuuidarr = vercodeuuid.split(",");
        if (vercodeuuidarr.length > 1 && !vercodeuuidarr[1].equals("")) {
            redisUtil.del("WJW_LOGIN_CODE_" + vercodeuuidarr[1]);
        }
        String guid = UUID.randomUUID().toString();
        String newvercode = vercodeuuidarr[0];
        redisUtil.set("WJW_LOGIN_CODE_" + guid, newvercode);
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", guid);
        return success(guid);
    }

    @ApiOperation("获取短信验证码")
    @PostMapping(value = "/getCode")
    public AjaxResult getCode(@RequestBody MessageRequest request) {
        if (StringUtils.isBlank(request.getPhone())) {
            throw new ServiceException("手机号不能为空");
        }
        if (StringUtils.isBlank(request.getSign())) {
            throw new ServiceException("验签失败");
        }
        String md5Str = Md5Utils.MD5(request.getPhone() + "wjwtest");
        if (!md5Str.equals(request.getSign())) {
            throw new ServiceException("验签失败");
        }
        String redisKey = "WJW_LOGIN_CODE_" + request.getPhone();
        String redisKeyLimit = "WJW_LOGIN_CODE_DAYLIMIT_" + DateUtils.getDateStrYYYYMM() + "_" + request.getPhone();
        String redisCode = (String) redisUtil.get(redisKey);
        Integer limit = (Integer) redisUtil.get(redisKeyLimit);
        if (StringUtils.isNotBlank(redisCode)) {
            throw new ServiceException("一分钟内不要重复发送");
        }
        if (null == limit) {
            limit = 0;
        }
        if (limit > 9) {
            throw new ServiceException("今日短信已达上限");
        }
        limit++;
        String code = MaskUtil.generatedcode(6);
        redisUtil.set(redisKey, code, 3 * 60L);
        redisUtil.set(redisKeyLimit, limit, 3600 * 24L);
        service.sendMsg(request.getPhone(), code);
        return success("发送成功");
    }


    @ApiOperation("修改密码")
    @PostMapping(value = "/resetPasswordPost")
    public AjaxResult resetPasswordPost(@RequestBody ResetPasswordRequest request) {
        LoginUser loginUser = getLoginUser();

        String password = loginUser.getPassword();
        SysUser sysUser = iSysUserService.selectUserByUserNameOrPhone(request.getUsername());
        if (null == sysUser) {
            return error("用户名输入有误");
        }
        if (!sysUser.getPassword().equals(password)) {
            return error("修改密码失败，旧密码错误");
        }
        if (request.getOldPassword().equals(request.getPassword())) {
            return error("新密码不能与旧密码相同");
        }
        request.setPassword(SecurityUtils.encryptPassword(request.getPassword()));
        if (iSysUserService.resetUserPwdByPhone(request.getUsername(), request.getPassword()) > 0) {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(request.getPassword());
            tokenService.setLoginUser(loginUser);
            return success();
        }
        return error("修改密码异常，请联系管理员");
    }
}
