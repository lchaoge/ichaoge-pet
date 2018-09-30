package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.GoodsImageMapper;
import com.ichaoge.pet.domain.entity.GoodsImage;
import com.ichaoge.pet.domain.entity.GoodsImageExample;
import com.ichaoge.pet.service.iservice.GoodsImageServiceI;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class GoodsImageServiceImpl extends RuntimeException implements GoodsImageServiceI {

    @Resource
    private GoodsImageMapper goodsImageMapper;

    @Override
    public int countByExample(GoodsImageExample example) {
        return goodsImageMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsImageExample example) {
        return goodsImageMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return goodsImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsImage record) {
        return goodsImageMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsImage record) {
        return goodsImageMapper.insertSelective(record);
    }

    @Override
    public List<GoodsImage> selectByExample(GoodsImageExample example) {
        return goodsImageMapper.selectByExample(example);
    }

    @Override
    public GoodsImage selectByPrimaryKey(Long id) {
        return goodsImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsImage record) {
        return goodsImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsImage record) {
        return goodsImageMapper.updateByPrimaryKey(record);
    }
}
