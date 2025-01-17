package com.px.system.service.impl;

import com.px.system.domain.Tag;
import com.px.system.mapper.TagMapper;
import com.px.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：盛剑波
 * @Date：2024/6/25 9:17
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTagsList(Tag tag) {
        return tagMapper.selectListByCondition(tag);
    }
}
