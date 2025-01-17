package com.px.system.domain.dto;

import lombok.Data;

@Data
public class TaskDto {
    /**
     * 考试id
     */
    private Integer taskId;

    /**
     * 搜索条件——手机号/姓名
     */
    private String search;
}
