package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.ArticleImage;
import com.ichaoge.pet.domain.entity.ArticleImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface ArticleImageServiceI {
    int countByExample(ArticleImageExample example);

    int deleteByExample(ArticleImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleImage record);

    int insertSelective(ArticleImage record);

    List<ArticleImage> selectByExample(ArticleImageExample example);

    ArticleImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleImage record);

    int updateByPrimaryKey(ArticleImage record);
}
