package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.ArticleComment;
import com.ichaoge.pet.domain.entity.ArticleCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface ArticleCommentServiceI {
    int countByExample(ArticleCommentExample example);

    int deleteByExample(ArticleCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExampleWithBLOBs(ArticleCommentExample example);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKeyWithBLOBs(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}
