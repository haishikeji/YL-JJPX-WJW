package com.px.system.domain;

import com.px.common.annotation.Excel;
import lombok.Data;

/**
 * @Author：盛剑波
 * @Date：2024/6/7 16:19
 */
@Data
public class QuestionExcel {

    @Excel(name = "题干",sort = 1)
    private String qTitle;

    @Excel(name = "题目类型(可选参数 单选题 多选题 判断题 案例)",sort = 2,width = 40)
    private String qTypeName;

    @Excel(name = "标签",sort = 3)
    private String tagName;

    @Excel(name = "分值",sort = 4)
    private Integer score;

    @Excel(name = "积分值",sort = 5)
    private Integer point;

    @Excel(name = "答案(多个选项;分割)",sort = 6,width = 20)
    private String qAnswer;

    @Excel(name = "选项A",sort = 7)
    private String optionA;

    @Excel(name = "选项B",sort = 8)
    private String optionB;

    @Excel(name = "选项C(依次扩展最多支持10个选项)",sort = 9,width = 30)
    private String optionC;

    @Excel(name = "选项D(如不存在该列为空)",sort = 10,width = 25)
    private String optionD;

    private String optionE;
    private String optionF;
    private String optionG;
    private String optionH;
    private String optionI;
    private String optionJ;
    private String optionK;
}
