package com.px.system.domain;

import com.px.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author：盛剑波
 * @Date：2024/6/3 15:13
 */
@Data
public class QuestionRelationBank  extends BaseEntity {

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 题库ID
     */
    @ApiModelProperty("题库ID")
    private Integer bankId;

    /**
     * 题目ID
     */
    @ApiModelProperty("题目ID")
    private Integer qId;
}
