package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.ArticleSort;
import com.ichaoge.pet.domain.entity.ArticleSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleSortMapper {
    int countByExample(ArticleSortExample example);

    int deleteByExample(ArticleSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    List<ArticleSort> selectByExampleWithBLOBs(ArticleSortExample example);

    List<ArticleSort> selectByExample(ArticleSortExample example);

    ArticleSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByExample(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKeyWithBLOBs(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
}