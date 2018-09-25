package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PhotoAlbumLabelSortMapper;
import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSort;
import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSortExample;
import com.ichaoge.pet.service.iservice.PhotoAlbumLabelSortServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/25.
 */
@Service
public class PhotoAlbumLabelSortServiceImpl implements PhotoAlbumLabelSortServiceI {

    @Resource
    private PhotoAlbumLabelSortMapper photoAlbumLabelSortMapper;

    @Override
    public int countByExample(PhotoAlbumLabelSortExample example) {
        return photoAlbumLabelSortMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PhotoAlbumLabelSortExample example) {
        return photoAlbumLabelSortMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return photoAlbumLabelSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PhotoAlbumLabelSort record) {
        return photoAlbumLabelSortMapper.insert(record);
    }

    @Override
    public int insertSelective(PhotoAlbumLabelSort record) {
        return photoAlbumLabelSortMapper.insertSelective(record);
    }

    @Override
    public List<PhotoAlbumLabelSort> selectByExample(PhotoAlbumLabelSortExample example) {
        return photoAlbumLabelSortMapper.selectByExample(example);
    }

    @Override
    public PhotoAlbumLabelSort selectByPrimaryKey(Long id) {
        return photoAlbumLabelSortMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PhotoAlbumLabelSort record) {
        return photoAlbumLabelSortMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PhotoAlbumLabelSort record) {
        return photoAlbumLabelSortMapper.updateByPrimaryKey(record);
    }
}
