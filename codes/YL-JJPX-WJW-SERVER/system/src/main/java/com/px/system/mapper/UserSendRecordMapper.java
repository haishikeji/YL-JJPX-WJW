package com.px.system.mapper;

import com.px.system.domain.UserSendRecord;

import java.util.List;

/**
 * Mapper接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface UserSendRecordMapper {
    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    public UserSendRecord selectUserSendRecordById(Long id);

    /**
     * 查询列表
     *
     * @param userSendRecord
     * @return 集合
     */
    public List<UserSendRecord> selectUserSendRecordList(UserSendRecord userSendRecord);

    /**
     * 新增
     *
     * @param userSendRecord
     * @return 结果
     */
    public int insertUserSendRecord(UserSendRecord userSendRecord);

    /**
     * 修改
     *
     * @param userSendRecord
     * @return 结果
     */
    public int updateUserSendRecord(UserSendRecord userSendRecord);

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteUserSendRecordById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserSendRecordByIds(Long[] ids);
}
