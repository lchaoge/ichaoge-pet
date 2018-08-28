package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.PetSort;
import com.ichaoge.pet.domain.entity.PetSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetSortMapper {
    int countByExample(PetSortExample example);

    int deleteByExample(PetSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PetSort record);

    int insertSelective(PetSort record);

    List<PetSort> selectByExample(PetSortExample example);

    PetSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PetSort record, @Param("example") PetSortExample example);

    int updateByExample(@Param("record") PetSort record, @Param("example") PetSortExample example);

    int updateByPrimaryKeySelective(PetSort record);

    int updateByPrimaryKey(PetSort record);
}