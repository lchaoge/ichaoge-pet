package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PhotoAlbumMapper;
import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumExample;
import com.ichaoge.pet.service.iservice.PhotoAlbumServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
@Service
public class PhotoAlbumServiceImpl implements PhotoAlbumServiceI {

    @Resource
    private PhotoAlbumMapper photoAlbumMapper;

    @Override
    public int countByExample(PhotoAlbumExample example) {
        return photoAlbumMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PhotoAlbumExample example) {
        return photoAlbumMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return photoAlbumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PhotoAlbum record) {
        return photoAlbumMapper.insert(record);
    }

    @Override
    public int insertSelective(PhotoAlbum record) {
        return photoAlbumMapper.insertSelective(record);
    }

    @Override
    public List<PhotoAlbum> selectByExampleWithBLOBs(PhotoAlbumExample example) {
        return photoAlbumMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<PhotoAlbum> selectByExample(PhotoAlbumExample example) {
        return photoAlbumMapper.selectByExample(example);
    }

    @Override
    public PhotoAlbum selectByPrimaryKey(Long id) {
        return photoAlbumMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PhotoAlbum record) {
        return photoAlbumMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(PhotoAlbum record) {
        return photoAlbumMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(PhotoAlbum record) {
        return photoAlbumMapper.updateByPrimaryKey(record);
    }
}
