package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 9:05
 */
@Data
public class ExamRequest implements Serializable {

    /**
     * 用户登陆名
     */
    @ApiModelProperty(value = "考试ID 二维码跳转前端带入该参数", required = true)
    private Integer taskId;

    @ApiModelProperty("考核方式 1 线上考试 2 练习模式 3 现场考试 4 积分模式")
    @NotNull
    private Integer testType;
}
