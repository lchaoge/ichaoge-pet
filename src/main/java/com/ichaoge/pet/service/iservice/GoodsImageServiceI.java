package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.GoodsImage;
import com.ichaoge.pet.domain.entity.GoodsImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface GoodsImageServiceI {
    int countByExample(GoodsImageExample example);

    int deleteByExample(GoodsImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsImage record);

    int insertSelective(GoodsImage record);

    List<GoodsImage> selectByExample(GoodsImageExample example);

    GoodsImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsImage record);

    int updateByPrimaryKey(GoodsImage record);
}
