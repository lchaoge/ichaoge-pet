package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.ArticleImageMapper;
import com.ichaoge.pet.domain.entity.ArticleImage;
import com.ichaoge.pet.domain.entity.ArticleImageExample;
import com.ichaoge.pet.service.iservice.ArticleImageServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by choage on 2018/9/18.
 */
@Service
public class ArticleImageServiceImpl implements ArticleImageServiceI {
    @Resource
    private ArticleImageMapper articleImageMapper;

    @Override
    public int countByExample(ArticleImageExample example) {
        return articleImageMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleImageExample example) {
        return articleImageMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return articleImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArticleImage record) {
        return articleImageMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleImage record) {
        return articleImageMapper.insertSelective(record);
    }

    @Override
    public List<ArticleImage> selectByExample(ArticleImageExample example) {
        return articleImageMapper.selectByExample(example);
    }

    @Override
    public ArticleImage selectByPrimaryKey(Long id) {
        return articleImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleImage record) {
        return articleImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ArticleImage record) {
        return articleImageMapper.updateByPrimaryKey(record);
    }
}
