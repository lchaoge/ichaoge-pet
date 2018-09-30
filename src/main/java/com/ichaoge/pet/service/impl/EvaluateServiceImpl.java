package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.EvaluateMapper;
import com.ichaoge.pet.domain.entity.Evaluate;
import com.ichaoge.pet.domain.entity.EvaluateExample;
import com.ichaoge.pet.service.iservice.EvaluateServiceI;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class EvaluateServiceImpl extends RuntimeException implements EvaluateServiceI {

    @Resource
    private EvaluateMapper evaluateMapper;

    @Override
    public int countByExample(EvaluateExample example) {
        return evaluateMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EvaluateExample example) {
        return evaluateMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return evaluateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Evaluate record) {
        return evaluateMapper.insert(record);
    }

    @Override
    public int insertSelective(Evaluate record) {
        return evaluateMapper.insertSelective(record);
    }

    @Override
    public List<Evaluate> selectByExample(EvaluateExample example) {
        return evaluateMapper.selectByExample(example);
    }

    @Override
    public Evaluate selectByPrimaryKey(Long id) {
        return evaluateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Evaluate record) {
        return evaluateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Evaluate record) {
        return evaluateMapper.updateByPrimaryKey(record);
    }
}
