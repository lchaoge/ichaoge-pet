package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PetSort;
import com.ichaoge.pet.domain.entity.PetSortExample;

import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
public interface PetSortServiceI {
    int deleteByPrimaryKey(Long id);

    int insert(PetSort record);

    int insertSelective(PetSort record);

    List<PetSort> selectByExample(PetSortExample example);

    PetSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PetSort record);

    int updateByPrimaryKey(PetSort record);

}
