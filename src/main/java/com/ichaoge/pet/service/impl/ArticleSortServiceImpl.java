package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.ArticleSortMapper;
import com.ichaoge.pet.domain.entity.ArticleSort;
import com.ichaoge.pet.domain.entity.ArticleSortExample;
import com.ichaoge.pet.service.iservice.ArticleSortServiceI;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class ArticleSortServiceImpl extends RuntimeException implements ArticleSortServiceI {

    @Resource
    private ArticleSortMapper articleSortMapper;

    @Override
    public int countByExample(ArticleSortExample example) {
        return articleSortMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleSortExample example) {
        return articleSortMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return articleSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArticleSort record) {
        return articleSortMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleSort record) {
        return articleSortMapper.insertSelective(record);
    }

    @Override
    public List<ArticleSort> selectByExampleWithBLOBs(ArticleSortExample example) {
        return articleSortMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleSort> selectByExample(ArticleSortExample example) {
        return articleSortMapper.selectByExample(example);
    }

    @Override
    public ArticleSort selectByPrimaryKey(Long id) {
        return articleSortMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleSort record) {
        return articleSortMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ArticleSort record) {
        return articleSortMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(ArticleSort record) {
        return articleSortMapper.updateByPrimaryKey(record);
    }
}
