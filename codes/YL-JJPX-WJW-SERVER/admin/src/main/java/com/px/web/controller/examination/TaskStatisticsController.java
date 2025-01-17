package com.px.web.controller.examination;

import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.entity.ExportUser;
import com.px.common.core.domain.entity.SysDictData;
import com.px.common.core.domain.entity.SysUser;
import com.px.common.core.page.TableDataInfo;
import com.px.common.utils.DateUtils;
import com.px.common.utils.SecurityUtils;
import com.px.common.utils.poi.ExcelUtil;
import com.px.system.domain.Article;
import com.px.system.domain.ArticleUser;
import com.px.system.domain.TaskStatistics;
import com.px.system.mapper.SysDictDataMapper;
import com.px.system.service.ArticleService;
import com.px.system.service.IArticleUserService;
import com.px.system.service.ISysUserService;
import com.px.system.service.MissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author 品讯科技
 * @date 2024-08
 */
@RestController
@RequestMapping("/statistics")
public class TaskStatisticsController extends BaseController {

    @Autowired
    private MissionService missionService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private IArticleUserService articleUserService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 查询考试任务统计
     */
    @PreAuthorize("@ss.hasPermi('statistics:task:list')")
    @GetMapping("/task/list")
    public TableDataInfo taskList(TaskStatistics record) {
        startPage();
        record.setDeptId(SecurityUtils.getDeptId());
        if(null==record.getYear()|| record.getYear().isEmpty()){
            record.setYear(DateUtils.formatDateToStr(new Date(), "yyyy"));
        }
        List<TaskStatistics> list = missionService.selectStatisticsByCondition(record);
        return getDataTable(list);
    }

    @GetMapping("/task/deptList/lastList")
    public TableDataInfo lastList(Long deptId ,Long taskId) {
        startPage();
        TaskStatistics testTask=new TaskStatistics();
        testTask.setTaskId(taskId.intValue());
        testTask.setDeptId(deptId);
        List<TaskStatistics> list = missionService.selectLastList(testTask);
        return getDataTable(list);
    }


    @PostMapping("/task/deptList/lastList/export")
    public void vieInfoExport(HttpServletResponse response, Long deptId ,Long taskId)
    {
        List<ExportUser> list = new ArrayList<>();

        TaskStatistics testTask=new TaskStatistics();
        testTask.setTaskId(taskId.intValue());
        testTask.setDeptId(deptId);
        List<TaskStatistics> testTasklist = missionService.selectLastList(testTask);

        for (TaskStatistics taskStatistics : testTasklist) {
            ExportUser exportUser = new ExportUser();
            exportUser.setDeptName(taskStatistics.getCoName());
            exportUser.setNickName(taskStatistics.getNickName());
            exportUser.setPhonenumber(taskStatistics.getPhonenumber());
            list.add(exportUser);
        }

        ExcelUtil<ExportUser> util = new ExcelUtil<ExportUser>(ExportUser.class);

        util.exportExcel(response, list, "未考人员数据");
    }






    @PreAuthorize("@ss.hasPermi('statistics:task:info')")
    @ApiOperation("查询答题记录")
    @GetMapping("/task/deptList")
    public TableDataInfo getTestStatisticsPage(Long taskId) {
        startPage();
        TaskStatistics testTask=new TaskStatistics();
        testTask.setTaskId(taskId.intValue());
        testTask.setDeptId(SecurityUtils.getDeptId());
        List<TaskStatistics> list = missionService.getTaskStatisticsPage(testTask);
        for(TaskStatistics t:list){
            t.setLastNum(t.getJoinNum()-t.getTestNum());
        }
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('statistics:task:export')")
    @ApiOperation("统计导出")
    @PostMapping("/exportTask")
    public void exportGrade(HttpServletResponse response, TaskStatistics record) {
        List<TaskStatistics> list = missionService.getTaskStatisticsPage(record);
        for(TaskStatistics t:list){
            t.setLastNum(t.getJoinNum()-t.getTestNum());
            t.setTestRate(t.getTestRate());
        }
        ExcelUtil<TaskStatistics> util = new ExcelUtil<TaskStatistics>(TaskStatistics.class);
        util.exportExcel(response, list, "考试成绩");
    }

    /**
     * 查询考试任务统计
     */
    @PreAuthorize("@ss.hasPermi('statistics:article:list')")
    @GetMapping("/article/list")
    public TableDataInfo articleList(Article article) {
        startPage();
        article.setDeptId(SecurityUtils.getDeptId());
        List<Article> list = articleService.selectStatisticsByCondition(article);
        return getDataTable(list);
    }


    /**
     * 根据文章编号获取已阅人员信息
     */
    @GetMapping(value = "/article/vieInfo")
    public TableDataInfo getVieInfo(Long articleId)
    {
        List<SysUser> list = new ArrayList<>();

        ArticleUser articleUser = new ArticleUser();
        articleUser.setArticleId(articleId);
        List<ArticleUser> articleUsers = articleUserService.selectArticleUserList(articleUser);

        Long[] userIds = new Long[articleUsers.size()];
        for (int i = 0; i < articleUsers.size(); i++) {
            userIds[i] = articleUsers.get(i).getUserId();
        }

        startPage();
        list = sysUserService.selectVieUserList(userIds,SecurityUtils.getDeptId());
        return getDataTable(list);
    }


    @PostMapping("/article/vieInfo/export")
    public void vieInfoExport(HttpServletResponse response, Long articleId)
    {
        List<SysUser> list = new ArrayList<>();

        ArticleUser articleUser = new ArticleUser();
        articleUser.setArticleId(articleId);
        List<ArticleUser> articleUsers = articleUserService.selectArticleUserList(articleUser);

        Long[] userIds = new Long[articleUsers.size()];
        for (int i = 0; i < articleUsers.size(); i++) {
            userIds[i] = articleUsers.get(i).getUserId();
        }


        list = sysUserService.selectVieUserList(userIds,SecurityUtils.getDeptId());

        if(list!=null&&list.size()>0){
            List<ExportUser> exportUserList = new ArrayList<>();
            for (SysUser sysUser : list) {
                ExportUser exportUser = new ExportUser();
                exportUser.setPhonenumber(sysUser.getPhonenumber());
                exportUser.setDeptName(sysUser.getDeptName());
                exportUser.setNickName(sysUser.getNickName());
                exportUserList.add(exportUser);
            }
            ExcelUtil<ExportUser> util = new ExcelUtil<ExportUser>(ExportUser.class);

            util.exportExcel(response, exportUserList, "已阅人员数据");
        }
    }



    /**
     * 根据文章编号获取未阅人员信息
     */
    @GetMapping(value = "/article/notVieInfo")
    public TableDataInfo getNotVieInfo(Long articleId)
    {
//        System.out.println("article:"+article.toString());
        System.out.println("articleId:"+articleId);

        List<SysUser> list = new ArrayList<>();

        ArticleUser articleUser = new ArticleUser();
        articleUser.setArticleId(articleId);
        List<ArticleUser> articleUsers = articleUserService.selectArticleUserList(articleUser);
        Long[] userIds = new Long[articleUsers.size()];
        for (int i = 0; i < articleUsers.size(); i++) {
            userIds[i] = articleUsers.get(i).getUserId();
        }

        startPage();
        list = sysUserService.selectNotVieUserList(userIds,SecurityUtils.getDeptId());


        return getDataTable(list);
    }


    @PostMapping("/article/notVieInfo/export")
    public void notVieInfoExport(HttpServletResponse response, Long articleId)
    {
        List<ExportUser> list = new ArrayList<>();

        ArticleUser articleUser = new ArticleUser();
        articleUser.setArticleId(articleId);
        List<ArticleUser> articleUsers = articleUserService.selectArticleUserList(articleUser);
        Long[] userIds = new Long[articleUsers.size()];
        for (int i = 0; i < articleUsers.size(); i++) {
            userIds[i] = articleUsers.get(i).getUserId();
        }

        List<SysUser> sysUserlist = sysUserService.selectNotVieUserList(userIds,SecurityUtils.getDeptId());
        if(sysUserlist!=null && sysUserlist.size()>0){
            for (SysUser sysUser : sysUserlist) {
                ExportUser exportUser = new ExportUser();
                exportUser.setNickName(sysUser.getNickName());
                exportUser.setPhonenumber(sysUser.getPhonenumber());
                exportUser.setDeptName(sysUser.getDeptName());
                list.add(exportUser);
            }
        }

        ExcelUtil<ExportUser> util = new ExcelUtil<ExportUser>(ExportUser.class);

        util.exportExcel(response, list, "未阅人员数据");
    }




    @PostMapping("/article/export")
    public void export(HttpServletResponse response, Article article)
    {
        article.setDeptId(SecurityUtils.getDeptId());
        List<Article> list = articleService.selectStatisticsByCondition(article);
        for (Article article1 : list) {
            String type = article1.getType();
            SysDictData dictData = new SysDictData();
            dictData.setDictValue(type);
            dictData.setDictType("article_type");
            List<SysDictData> sysDictData = sysDictDataMapper.selectDictDataList(dictData);
            if (!CollectionUtils.isEmpty(sysDictData)) {
                article1.setType(sysDictData.get(0).getDictLabel());
            }
        }
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);

        util.exportExcel(response, list, "文章浏览统计数据");
    }


}
