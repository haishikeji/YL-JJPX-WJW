package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 10:35
 */
@Data
public class SignLoginRequest implements Serializable {

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "考试ID",required = true)
    private Integer taskId;

    @ApiModelProperty(value = "是否新的考试 1 是  0 否",required = true)
    private Integer newTest;
}
