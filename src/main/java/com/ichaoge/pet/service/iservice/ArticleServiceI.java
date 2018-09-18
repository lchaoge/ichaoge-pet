package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Article;
import com.ichaoge.pet.domain.entity.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface ArticleServiceI {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}
