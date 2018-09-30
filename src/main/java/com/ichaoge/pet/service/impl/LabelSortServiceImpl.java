package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.domain.entity.LabelSort;
import com.ichaoge.pet.domain.entity.LabelSortExample;
import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.LabelSortMapper;
import com.ichaoge.pet.service.iservice.LabelSortServiceI;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class LabelSortServiceImpl extends RuntimeException implements LabelSortServiceI {

    @Resource
    private LabelSortMapper labelSortMapper;

    @Override
    public int countByExample(LabelSortExample example) {
        return labelSortMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LabelSortExample example) {
        return labelSortMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return labelSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LabelSort record) {
        return labelSortMapper.insert(record);
    }

    @Override
    public int insertSelective(LabelSort record) {
        return labelSortMapper.insertSelective(record);
    }

    @Override
    public List<LabelSort> selectByExample(LabelSort param) {
        LabelSortExample labelSortExample = new LabelSortExample();
        LabelSortExample.Criteria criteria = labelSortExample.createCriteria();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(param.getTitle())) {
            criteria.andTitleEqualTo(param.getTitle());
        }
        labelSortExample.setOrderByClause("id desc");
        return labelSortMapper.selectByExample(labelSortExample);
    }

    @Override
    public LabelSort selectByPrimaryKey(Long id) {
        return labelSortMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LabelSort record) {
        return labelSortMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LabelSort record) {
        return labelSortMapper.updateByPrimaryKey(record);
    }
}
