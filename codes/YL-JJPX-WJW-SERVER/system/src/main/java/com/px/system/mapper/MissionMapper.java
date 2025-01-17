package com.px.system.mapper;

import com.px.system.domain.Mission;
import com.px.system.domain.TaskStatistics;

import java.util.List;
import java.util.Map;

/**
 * @Author：盛剑波
 * @Date：2024/6/3 15:42
 */
public interface MissionMapper {

    /**
     * 查询考试任务列表分页
     *
     * @param mission 参数配置信息
     * @return 结果
     */
    List<Mission> selectMissionList(Mission mission);


    /**
     * 查询考试任务
     *
     * @param mission 参数配置信息
     * @return 结果
     */
    Mission selectMissionById(Mission mission);
    /**
     * 新增考试任务
     *
     * @param mission 参数配置信息
     * @return 结果
     */
    int addMission(Mission mission);

    /**
     * 修改考试任务
     *
     * @param mission 参数配置信息
     * @return 结果
     */
    int updateMission(Mission mission);

    /**
     * 删除考试任务
     *
     * @param missionId 参数配置信息
     * @return 结果
     */
    int deleteMissionByIds(Long[] missionId);

    /**
     * 新增选项
     *
     * @param mission 参数配置信息
     * @return 结果
     */
    int addTaskPost(Mission mission);


    /**
     * 删除选项
     *
     * @param taskId 参数配置信息
     * @return 结果
     */
    int deletePost(Integer taskId);


    Mission selectByPrimaryKey(Integer id);


    List<TaskStatistics> selectStatisticsByCondition(TaskStatistics record);

    List<TaskStatistics> getTaskStatisticsPage(TaskStatistics user);

    List<TaskStatistics> selectLastList(TaskStatistics user);

    public List<Map<String, Object>> selectUserPassExam();

}
