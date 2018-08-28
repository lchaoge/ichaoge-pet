package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.ArticleImage;
import com.ichaoge.pet.domain.entity.ArticleImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleImageMapper {
    int countByExample(ArticleImageExample example);

    int deleteByExample(ArticleImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleImage record);

    int insertSelective(ArticleImage record);

    List<ArticleImage> selectByExample(ArticleImageExample example);

    ArticleImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleImage record, @Param("example") ArticleImageExample example);

    int updateByExample(@Param("record") ArticleImage record, @Param("example") ArticleImageExample example);

    int updateByPrimaryKeySelective(ArticleImage record);

    int updateByPrimaryKey(ArticleImage record);
}