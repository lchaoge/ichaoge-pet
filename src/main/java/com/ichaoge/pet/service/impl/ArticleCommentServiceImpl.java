package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.ArticleCommentMapper;
import com.ichaoge.pet.domain.entity.ArticleComment;
import com.ichaoge.pet.domain.entity.ArticleCommentExample;
import com.ichaoge.pet.service.iservice.ArticleCommentServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by choage on 2018/9/18.
 */
@Service
@Transactional
public class ArticleCommentServiceImpl extends RuntimeException implements ArticleCommentServiceI {

    @Resource
    private ArticleCommentMapper articleCommentMapper;

    @Override
    public int countByExample(ArticleCommentExample example) {
        return articleCommentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleCommentExample example) {
        return articleCommentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return articleCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArticleComment record) {
        return articleCommentMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleComment record) {
        return articleCommentMapper.insertSelective(record);
    }

    @Override
    public List<ArticleComment> selectByExampleWithBLOBs(ArticleCommentExample example) {
        return articleCommentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleComment> selectByExample(ArticleCommentExample example) {
        return articleCommentMapper.selectByExample(example);
    }

    @Override
    public ArticleComment selectByPrimaryKey(Long id) {
        return articleCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleComment record) {
        return articleCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ArticleComment record) {
        return articleCommentMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(ArticleComment record) {
        return articleCommentMapper.updateByPrimaryKey(record);
    }
}
