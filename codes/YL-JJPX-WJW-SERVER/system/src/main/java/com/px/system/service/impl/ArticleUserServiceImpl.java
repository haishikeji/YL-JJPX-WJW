package com.px.system.service.impl;

import com.px.common.utils.DateUtils;
import com.px.system.domain.ArticleUser;
import com.px.system.mapper.ArticleUserMapper;
import com.px.system.service.IArticleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员浏览文章记录Service业务层处理
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class ArticleUserServiceImpl implements IArticleUserService 
{
    @Autowired
    private ArticleUserMapper articleUserMapper;

    /**
     * 查询人员浏览文章记录
     * 
     * @param id 人员浏览文章记录主键
     * @return 人员浏览文章记录
     */
    @Override
    public ArticleUser selectArticleUserById(Long id)
    {
        return articleUserMapper.selectArticleUserById(id);
    }

    /**
     * 查询人员浏览文章记录列表
     * 
     * @param articleUser 人员浏览文章记录
     * @return 人员浏览文章记录
     */
    @Override
    public List<ArticleUser> selectArticleUserList(ArticleUser articleUser)
    {
        return articleUserMapper.selectArticleUserList(articleUser);
    }

    /**
     * 新增人员浏览文章记录
     * 
     * @param articleUser 人员浏览文章记录
     * @return 结果
     */
    @Override
    public int insertArticleUser(ArticleUser articleUser)
    {
        articleUser.setCreateTime(DateUtils.getNowDate());
        return articleUserMapper.insertArticleUser(articleUser);
    }

    /**
     * 修改人员浏览文章记录
     * 
     * @param articleUser 人员浏览文章记录
     * @return 结果
     */
    @Override
    public int updateArticleUser(ArticleUser articleUser)
    {
        return articleUserMapper.updateArticleUser(articleUser);
    }

    /**
     * 批量删除人员浏览文章记录
     * 
     * @param ids 需要删除的人员浏览文章记录主键
     * @return 结果
     */
    @Override
    public int deleteArticleUserByIds(Long[] ids)
    {
        return articleUserMapper.deleteArticleUserByIds(ids);
    }

    /**
     * 删除人员浏览文章记录信息
     * 
     * @param id 人员浏览文章记录主键
     * @return 结果
     */
    @Override
    public int deleteArticleUserById(Long id)
    {
        return articleUserMapper.deleteArticleUserById(id);
    }
}
