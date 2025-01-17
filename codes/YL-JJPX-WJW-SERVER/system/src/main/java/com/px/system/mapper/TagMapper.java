package com.px.system.mapper;

import com.px.system.domain.Tag;

import java.util.List;

/**
 * @Author：盛剑波
 * @Date：2024/6/25 9:06
 */
public interface TagMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    List<Tag> selectListByCondition(Tag record);

    Tag selectByCondition(Tag record);



}
