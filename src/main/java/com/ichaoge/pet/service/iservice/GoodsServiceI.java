package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Goods;
import com.ichaoge.pet.domain.entity.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface GoodsServiceI {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}
