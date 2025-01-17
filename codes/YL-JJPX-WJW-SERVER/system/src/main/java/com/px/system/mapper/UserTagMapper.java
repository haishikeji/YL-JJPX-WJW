package com.px.system.mapper;

import com.px.system.domain.UserTag;

/**
 * @Author：盛剑波
 * @Date：2024/6/24 14:41
 */
public interface UserTagMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserTag record);

    UserTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTag record);

    int delUserTag(Integer userId);

}
