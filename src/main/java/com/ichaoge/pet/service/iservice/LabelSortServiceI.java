package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.LabelSort;
import com.ichaoge.pet.domain.entity.LabelSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface LabelSortServiceI {
    int countByExample(LabelSortExample example);

    int deleteByExample(LabelSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LabelSort record);

    int insertSelective(LabelSort record);

    List<LabelSort> selectByExample(LabelSortExample example);

    LabelSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LabelSort record);

    int updateByPrimaryKey(LabelSort record);
}
