package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 考试详情
 * @author 品讯科技
 * @date 2024-08
 * @PackageName:com.px.wjwtest.pojo.dmo
 * @ClassName: TDept
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Builder
public class UserTestLog implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 用户手机号
     */
    @ApiModelProperty("用户手机号")
    private String phone;

    /**
     * 用户考试任务ID
     */
    @ApiModelProperty("用户考试任务ID")
    private Integer userTaskId;

    /**
     * 题目ID
     */
    @ApiModelProperty("题目ID")
    private Integer qId;

    /**
     * 提交选项
     */
    @ApiModelProperty("提交选项")
    private String qAnswer;

    @ApiModelProperty("答案选项")
    private String answer;

    /**
     * 得分
     */
    @ApiModelProperty("得分")
    private Integer score;

//    @ApiModelProperty("积分")
//    private Integer point;
}
