package com.px.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.utils.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 考试任务
 * @author 品讯科技
 * @date 2024-08
 * @PackageName:com.px.wjwtest.pojo.dmo
 * @ClassName: TDept
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class TaskStatistics implements Serializable {
    /**
     * 考试任务ID
     */
    @ApiModelProperty("考试任务ID")
    private Integer id;

    private Integer taskId;

    private String year;

    @ApiModelProperty("姓名")
    private String nickName;

    @ApiModelProperty("所属单位")
    @Excel(name = "参考单位")
    private String coName;

    //电话
    private String phonenumber;

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
    /**
     * 考试任务状态  0待发布 1已发布未开始 2 已发布考核中 3 已发布已结束 4 已下架
     *  1 2 3  默认 发布 上架
     */
    @ApiModelProperty("考试任务状态  0待发布 1已发布未开始 2 已发布考核中 3 已发布已结束 4 已下架 ")
    private Integer taskStatus;
    private String taskStatusName;
    private String testTime;
    @Excel(name = "应考人数")
    private Integer joinNum;
    @Excel(name = "参考人数")
    private Integer testNum;
    @Excel(name = "参考率")
    private String testRate;
    @Excel(name = "平均分")
    private String avgScore ="0";
    @Excel(name = "未考人数")
    private Integer lastNum;
    private Long deptId;

    public String getTestTypeName() {
        if (null!=testType){
            switch (testType){
                case 1: return "线上考试";
                case 2: return "练习模式";
                case 3: return "现场考试";
                case 4: return "积分模式";
            }
        }
        return testTypeName;
    }

    public String getTaskStatusName() {
        if (taskStatus!=null){
            switch (taskStatus){
                case 1: return "未开始";
                case 2: return "考核中";
                case 3: return "已结束";
            }
        }
        return taskStatusName;
    }

    public String getTestTime() {
        String begin = DateUtils.formatDateToStr(testBeginTime,DateUtils.YYYY_MM_DD);
        String end = DateUtils.formatDateToStr(testEndTime,DateUtils.YYYY_MM_DD);
        return begin+"——"+end;
    }

    public String getTestRate() {
        if (testNum!=null && joinNum!=null){
            testRate = joinNum>0 ? new BigDecimal(testNum).multiply(new BigDecimal("100")).divide(new BigDecimal(joinNum),2,BigDecimal.ROUND_HALF_UP).toString()+"%":"-";
            return testRate;
        }
        return "";
    }
}
