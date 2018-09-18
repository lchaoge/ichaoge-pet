package com.ichaoge.pet.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ichaoge.pet.dao.mapper.GoodsMapper;
import com.ichaoge.pet.domain.entity.Goods;
import com.ichaoge.pet.domain.entity.GoodsExample;
import com.ichaoge.pet.service.iservice.GoodsServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
public class GoodsServiceImpl implements GoodsServiceI {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int countByExample(GoodsExample example) {
        return goodsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsExample example) {
        return goodsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public List<Goods> selectByExampleWithBLOBs(GoodsExample example) {
        return goodsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Goods> selectByExample(GoodsExample example) {
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Goods selectByPrimaryKey(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Goods record) {
        return goodsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }
}
