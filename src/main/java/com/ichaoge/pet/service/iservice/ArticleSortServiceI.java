package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.ArticleSort;
import com.ichaoge.pet.domain.entity.ArticleSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface ArticleSortServiceI {
    int countByExample(ArticleSortExample example);

    int deleteByExample(ArticleSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    List<ArticleSort> selectByExampleWithBLOBs(ArticleSortExample example);

    List<ArticleSort> selectByExample(ArticleSortExample example);

    ArticleSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKeyWithBLOBs(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
}
