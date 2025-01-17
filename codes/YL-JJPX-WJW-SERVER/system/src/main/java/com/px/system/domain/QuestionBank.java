package com.px.system.domain;


import com.px.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author：盛剑波
 * @Date：2024/6/3 15:13
 */
@Data
public class QuestionBank extends BaseEntity {

    List<QuestionRelationBank> questionList;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;
    /**
     * 题库名称
     */
    @ApiModelProperty("题库名称")
    private String bankName;
    /**
     * 题目数量
     */
    @ApiModelProperty("题目数量")
    private Integer qNum;
    /**
     * 单选数量
     */
    @ApiModelProperty("单选数量")
    private Integer qRadioNum;
    @ApiModelProperty("案例数量")
    private Integer qCaseNum;
    /**
     * 多选数量
     */
    @ApiModelProperty("多选数量")
    private Integer qCheckboxNum;
    /**
     * 判断数量
     */
    @ApiModelProperty("判断数量")
    private Integer qJudgeNum;
    /**
     * 合格分数线
     */
    @ApiModelProperty("合格分数线")
    private Integer passScore;
    /**
     * 排序类型 1 顺序 2 乱序
     */
    @ApiModelProperty("排序类型 1 顺序 2 乱序")
    private String sortType;
    @ApiModelProperty("标签")
    private String tag;
    private Date testStartTime;


    private Long deptId;

    //题目标签
    private Long[] questionTags;

    private String questionTag;
}
