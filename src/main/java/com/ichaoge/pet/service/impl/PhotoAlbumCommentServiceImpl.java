package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PhotoAlbumCommentMapper;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.entity.PhotoAlbumCommentExample;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumCommentParam;
import com.ichaoge.pet.domain.output.CommentFloor;
import com.ichaoge.pet.service.iservice.PhotoAlbumCommentServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int deleteByExample(PhotoAlbumComment param) {
        PhotoAlbumCommentExample photoAlbumCommentExample = new PhotoAlbumCommentExample();
        PhotoAlbumCommentExample.Criteria criteria = photoAlbumCommentExample.createCriteria();
        if(param.getId()!=null){
            criteria.andIdEqualTo(param.getId());
        }
        if(param.getPhotoAlbumId()!=null){
            criteria.andPhotoAlbumIdEqualTo(param.getPhotoAlbumId());
        }
        if(param.getUserId()!=null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if(param.getStayUserId()!=null){
            criteria.andStayUserIdEqualTo(param.getStayUserId());
        }
        if(param.getParentId()!=null){
            criteria.andParentIdEqualTo(param.getParentId());
        }
        return photoAlbumCommentMapper.deleteByExample(photoAlbumCommentExample);
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
    public List<PhotoAlbumComment> selectByExample(PhotoAlbumCommentParam param) {
        PhotoAlbumCommentExample photoAlbumCommentExample = new PhotoAlbumCommentExample();
        PhotoAlbumCommentExample.Criteria criteria = photoAlbumCommentExample.createCriteria();
        if(param.getId()!=null){
            criteria.andIdEqualTo(param.getId());
        }
        if(param.getPhotoAlbumId()!=null){
            criteria.andPhotoAlbumIdEqualTo(param.getPhotoAlbumId());
        }
        if(param.getUserId()!=null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if(param.getStayUserId()!=null){
            criteria.andStayUserIdEqualTo(param.getStayUserId());
        }
        if(param.getParentId()!=null){
            criteria.andParentIdEqualTo(param.getParentId());
        }
        return photoAlbumCommentMapper.selectByExample(photoAlbumCommentExample);
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

    // 查询当前评论的最后一个楼
    @Override
    public Long selectFloorByPhotoAlbumId(Long photoAlbumId) {
        return photoAlbumCommentMapper.selectFloorByPhotoAlbumId(photoAlbumId);
    }

    // 根据写真集ID查询写真集所有楼层
    @Override
    public List<CommentFloor> selectAllFloor(Long photoAlbumId) {
        List<CommentFloor> result = photoAlbumCommentMapper.selectAllFloor(photoAlbumId);
        for (CommentFloor commentFloor:result) {
            commentFloor.setChildren(photoAlbumCommentMapper.selectOneFloor(commentFloor));
        }
        return result;
    }
}
