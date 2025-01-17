package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 8:48
 */
@Data
public class UserTaskRequest implements Serializable {

    @ApiModelProperty("任务Id 可为空")
    private Integer taskId;
    @ApiModelProperty("任务类型 可为空 默认查所有 1 每日考核 2 年度考核")
    private Integer testType;

    @ApiModelProperty("年份 格式yyyy 为空全部")
    private String  year;

    @ApiModelProperty("考试任务状态 1未开始 2 考核中 3 已结束 为空 全部")
    private String taskStatus;


}
