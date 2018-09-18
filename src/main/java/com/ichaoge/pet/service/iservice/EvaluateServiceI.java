package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Evaluate;
import com.ichaoge.pet.domain.entity.EvaluateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface EvaluateServiceI {
    int countByExample(EvaluateExample example);

    int deleteByExample(EvaluateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    List<Evaluate> selectByExample(EvaluateExample example);

    Evaluate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}
