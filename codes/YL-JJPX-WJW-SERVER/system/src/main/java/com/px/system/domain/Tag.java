package com.px.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈岗位管理〉<br>
 * 〈功能详细描述〉
 *
 * @author 品讯科技
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class Tag implements Serializable {
    /**
     * 岗位ID
     */
    @ApiModelProperty("标签ID")
    private Integer id;

    /**
     * 岗位名称
     */
    @ApiModelProperty("标签名称")
    private String tagName;

    private String name;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 操作人
     */
    @ApiModelProperty("操作人")
    private String op;

    /**
     * 状态 1 启用 0 删除
     */
    @ApiModelProperty("状态 1 启用 0 删除")
    private Integer status;
}
