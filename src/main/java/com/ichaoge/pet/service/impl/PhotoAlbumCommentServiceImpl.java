package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PhotoAlbumCommentMapper;
import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.entity.PhotoAlbumCommentExample;
import com.ichaoge.pet.service.iservice.PhotoAlbumCommentServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/27.
 */
@Service
public class PhotoAlbumCommentServiceImpl implements PhotoAlbumCommentServiceI {

    @Resource
    private PhotoAlbumCommentMapper photoAlbumCommentMapper;

    @Override
    public int countByExample(PhotoAlbumCommentExample example) {
        return photoAlbumCommentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PhotoAlbumCommentExample example) {
        return photoAlbumCommentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return photoAlbumCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PhotoAlbumComment record) {
        return photoAlbumCommentMapper.insert(record);
    }

    @Override
    public int insertSelective(PhotoAlbumComment record) {
        return photoAlbumCommentMapper.insertSelective(record);
    }

    @Override
    public List<PhotoAlbumComment> selectByExampleWithBLOBs(PhotoAlbumCommentExample example) {

        return photoAlbumCommentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<PhotoAlbumComment> selectByExample(PhotoAlbumCommentExample example) {
        return photoAlbumCommentMapper.selectByExample(example);
    }

    @Override
    public PhotoAlbumComment selectByPrimaryKey(Long id) {
        return photoAlbumCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PhotoAlbumComment record) {
        return photoAlbumCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(PhotoAlbumComment record) {
        return photoAlbumCommentMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(PhotoAlbumComment record) {
        return photoAlbumCommentMapper.updateByPrimaryKey(record);
    }
}
