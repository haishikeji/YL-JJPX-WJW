package com.px.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 9:09
 */
@Data
public class TestInfoResponse implements Serializable {

    /**
     * 考试任务ID
     */
    @ApiModelProperty("考试任务ID")
    private Integer id;

    /**
     * 考试任务名称
     */
    @ApiModelProperty("考试任务名称")
    private String taskName;

    /**
     * 考核方式 1 每日考核 2 年度考试 3 现场考试
     */
    @ApiModelProperty("考核方式 1 线上考试 2 练习模式 3 现场考试 4 积分模式")
    private Integer testType;

    private String testTypeName;

//    public String getTestTypeName() {
//        if (null!=testType){
//            switch (testType){
//                case 1: return "线上考试";
//                case 2: return "练习模式";
//                case 3: return "现场考试";
//                case 4: return "积分模式";
//            }
//        }
//        return testTypeName;
//    }

    /**
     * 考试开始时间
     */
    @ApiModelProperty("考试开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date testBeginTime;

    /**
     * 考试截止时间
     */
    @ApiModelProperty("考试截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date testEndTime;


    private Integer testDuration;


    /**
     * 考试任务状态  0待发布 1已发布未开始 2 已发布考核中 3 已发布已结束 4 已下架
     *  1 2 3  默认 发布 上架
     */
    @ApiModelProperty("考试任务状态  1未开始 2 考核中 3 已结束")
    private Integer taskStatus;

    private String taskStatusName;

//    public String getTaskStatusName() {
//        if (taskStatus!=null){
//            switch (taskStatus){
//                case 1: return "未开始";
//                case 2: return "考核中";
//                case 3: return "已结束";
//            }
//        }
//        return taskStatusName;
//    }

    @ApiModelProperty("考试时长 分钟")
    private Integer testTimeMinute;
//
//    public Integer getTestTimeMinute() {
//        if (testDuration!=null ){
//            return testDuration;
//        }
//        return testTimeMinute;
//    }


    /**
     * 重考次数
     */
    @ApiModelProperty("重考次数")
    private Integer retryNum;

    /**
     * 是否展示分数 1是 0 否
     */
    @ApiModelProperty("是否展示分数 1是 0 否")
    private Integer isScore;

    @ApiModelProperty("考题总数量")
    private Integer totalNum;

    @ApiModelProperty("签到状态 1已签到 0 未签到")
    private Integer signStatus;
}
