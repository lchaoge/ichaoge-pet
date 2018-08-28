package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.LabelSort;
import com.ichaoge.pet.domain.entity.LabelSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelSortMapper {
    int countByExample(LabelSortExample example);

    int deleteByExample(LabelSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LabelSort record);

    int insertSelective(LabelSort record);

    List<LabelSort> selectByExample(LabelSortExample example);

    LabelSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LabelSort record, @Param("example") LabelSortExample example);

    int updateByExample(@Param("record") LabelSort record, @Param("example") LabelSortExample example);

    int updateByPrimaryKeySelective(LabelSort record);

    int updateByPrimaryKey(LabelSort record);
}