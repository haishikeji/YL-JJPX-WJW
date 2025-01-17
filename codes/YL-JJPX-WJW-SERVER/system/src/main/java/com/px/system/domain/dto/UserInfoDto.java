package com.px.system.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private long userId;

    /**
     * 用户标签
     */
    private String tagIds;

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 身份证号
     */
    private String certNo;
    /**
     * ‘0’表示人员不存在，‘1’表示存在
     */
    private String code;

    /**
     * 身份，A:组长、B导师、C学员
     */
    private String identity;
}
