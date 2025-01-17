package com.px.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @Author：盛剑波
 * @Date：2024/6/5 9:23
 */
@Data
public class Article extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 文章标题
     */
    @Excel(name = "文章标题")
    private String title;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章摘要
     */
    private String digest;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章类型
     */
    @Excel(name="文章类型")
    private String type;

    /**
     * 浏览量
     */
    private Long viewCounts=0L;

    /**
     * 年份
     */
    private String year;

    /**
     部门ID
     *
     */
    private Long deptId;

    /**
     * 所有人数
     */
    private Long allNum=0L;

    /**
     * 已阅人数
     */
    @Excel(name="已阅人数")
    private Long vieNum;

    /**
     * 未阅人数
     */
    @Excel(name="未阅人数")
    private Long notNum;

    private String beginTime;

    private String  endTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date createTime;
}
