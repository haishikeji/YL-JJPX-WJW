package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：盛剑波
 * @Date：2024/6/19 10:44
 */
@Data
public class QuestionListRequest implements Serializable {

    @ApiModelProperty(value = "提交的选项 选项内容",required = true)
    List<String> optionList;
    /**
     * 题目ID
     */
    @ApiModelProperty(value = "题目ID",required = true)
    private Integer id;
    @ApiModelProperty("题目类型 1单选题 2 多选题 3 判断题 4 案例")
    private Integer qType;
}
