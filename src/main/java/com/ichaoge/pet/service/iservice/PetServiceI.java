package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.domain.inputParam.PetParam;

import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
public interface PetServiceI {

    int insert(Pet record);

    int insertSelective(Pet record);

    List<Pet> selectByExample(PetParam param);

    Pet selectByPrimaryKey(Long id);

    Pet selectByCardNo(Long cardNo);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

}
