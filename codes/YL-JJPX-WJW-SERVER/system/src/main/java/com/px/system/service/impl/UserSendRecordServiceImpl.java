package com.px.system.service.impl;

import com.px.system.domain.UserSendRecord;
import com.px.system.mapper.UserSendRecordMapper;
import com.px.system.service.IUserSendRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class UserSendRecordServiceImpl implements IUserSendRecordService {
    @Autowired
    private UserSendRecordMapper UserSendRecordMapper;

    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public UserSendRecord selectUserSendRecordById(Long id) {
        return UserSendRecordMapper.selectUserSendRecordById(id);
    }

    /**
     * 查询列表
     *
     * @param UserSendRecord
     * @return
     */
    @Override
    public List<UserSendRecord> selectUserSendRecordList(UserSendRecord UserSendRecord) {
        return UserSendRecordMapper.selectUserSendRecordList(UserSendRecord);
    }

    /**
     * 新增
     *
     * @param UserSendRecord
     * @return 结果
     */
    @Override
    public int insertUserSendRecord(UserSendRecord UserSendRecord) {
        return UserSendRecordMapper.insertUserSendRecord(UserSendRecord);
    }

    /**
     * 修改
     *
     * @param UserSendRecord
     * @return 结果
     */
    @Override
    public int updateUserSendRecord(UserSendRecord UserSendRecord) {
        return UserSendRecordMapper.updateUserSendRecord(UserSendRecord);
    }

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Override
    public int deleteUserSendRecordByIds(Long[] ids) {
        return UserSendRecordMapper.deleteUserSendRecordByIds(ids);
    }

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    @Override
    public int deleteUserSendRecordById(Long id) {
        return UserSendRecordMapper.deleteUserSendRecordById(id);
    }
}
