package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PhotoAlbumImageMapper;
import com.ichaoge.pet.domain.entity.PhotoAlbumImage;
import com.ichaoge.pet.domain.entity.PhotoAlbumImageExample;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumImageParam;
import com.ichaoge.pet.service.iservice.PhotoAlbumImageServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
@Service
public class PhotoAlbumImageServiceImpl implements PhotoAlbumImageServiceI {

    @Resource
    private PhotoAlbumImageMapper photoAlbumImageMapper;

    @Override
    public int countByExample(PhotoAlbumImageExample example) {
        return photoAlbumImageMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PhotoAlbumImageExample example) {
        return photoAlbumImageMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return photoAlbumImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PhotoAlbumImage record) {
        return photoAlbumImageMapper.insert(record);
    }

    @Override
    public int insertSelective(PhotoAlbumImage record) {
        return photoAlbumImageMapper.insertSelective(record);
    }

    @Override
    public List<PhotoAlbumImage> selectByExample(PhotoAlbumImageParam param) {
        PhotoAlbumImageExample photoAlbumImageExample = new PhotoAlbumImageExample();
        PhotoAlbumImageExample.Criteria criteria = photoAlbumImageExample.createCriteria();
        if(param.getId()!=null){
            criteria.andIdEqualTo(param.getId());
        }
        if (param.getPetId()!=null) {
            criteria.andPetIdEqualTo(param.getPetId());
        }
        if (param.getPhotoAlbumId()!=null) {
            criteria.andPhotoAlbumIdEqualTo(param.getPhotoAlbumId());
        }

        photoAlbumImageExample.setOrderByClause("id desc");
        return photoAlbumImageMapper.selectByExample(photoAlbumImageExample);
    }

    @Override
    public PhotoAlbumImage selectByPrimaryKey(Long id) {
        return photoAlbumImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PhotoAlbumImage record) {
        return photoAlbumImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PhotoAlbumImage record) {
        return photoAlbumImageMapper.updateByPrimaryKey(record);
    }
}
