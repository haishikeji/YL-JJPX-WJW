package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 8:49
 */
@Data
@Builder
public class UserTaskResponse implements Serializable {
    @ApiModelProperty("考试任务列表")
    List<UserTaskDetailResponse> taskList;
    @ApiModelProperty("用户手机号")
    private String phone;
    @ApiModelProperty("姓名")
    private String nickName;
    @ApiModelProperty("每日任务总数")
    private Integer dailyNum;
    @ApiModelProperty("每日任务ID")
    private Integer dailyID;
    @ApiModelProperty("年度任务ID")
    private Integer annualId;
    @ApiModelProperty("参加的每日任务总数")
    private Integer testDailyNum;
    @ApiModelProperty("年度任务总数")
    private Integer annualNum;
    @ApiModelProperty("参加的年度任务总数")
    private Integer testAnnualNum;
    @ApiModelProperty("每日任务题目总数量")
    private Integer dailyQNum;
    @ApiModelProperty("参加的每日考试正确题目总数")
    private Integer testDailySuccessNum;
    @ApiModelProperty("参加的每日任务错误题目总数")
    private Integer testDailyFailNum;
    @ApiModelProperty("年度任务题目总数")
    private Integer annualQNum;
    @ApiModelProperty("参加的年度任务题目正确总数")
    private Integer testAnnualSuccessNum;
    @ApiModelProperty("参加的年度任务题目错误总数")
    private Integer testAnnualFailNum;


}
