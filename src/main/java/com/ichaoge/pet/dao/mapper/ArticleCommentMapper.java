package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.ArticleComment;
import com.ichaoge.pet.domain.entity.ArticleCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCommentMapper {
    int countByExample(ArticleCommentExample example);

    int deleteByExample(ArticleCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExampleWithBLOBs(ArticleCommentExample example);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    int updateByExample(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKeyWithBLOBs(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}