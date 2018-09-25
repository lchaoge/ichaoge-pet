package com.ichaoge.pet.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ichaoge.pet.common.constant.CommConst;
import com.ichaoge.pet.dao.mapper.PhotoAlbumMapper;
import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.*;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumImageParam;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.domain.output.PhotoAlbumOutput;
import com.ichaoge.pet.service.iservice.PhotoAlbumImageServiceI;
import com.ichaoge.pet.service.iservice.PhotoAlbumServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
@Service
public class PhotoAlbumServiceImpl implements PhotoAlbumServiceI {

    @Resource
    private PhotoAlbumMapper photoAlbumMapper;
    @Resource
    private PhotoAlbumImageServiceI photoAlbumImageServiceI;

    @Override
    public int countByExample(PhotoAlbumParam param) {
        PhotoAlbumExample photoAlbumExample = new PhotoAlbumExample();
        PhotoAlbumExample.Criteria criteria = photoAlbumExample.createCriteria();
        criteria.andPetIdEqualTo(param.getPetId());
        return photoAlbumMapper.countByExample(photoAlbumExample);
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
    public List<PhotoAlbum> selectByExample(PhotoAlbumParam param) {
        PhotoAlbumExample photoAlbumExample = new PhotoAlbumExample();
        PhotoAlbumExample.Criteria criteria = photoAlbumExample.createCriteria();
        criteria.andPetIdEqualTo(param.getPetId());
        photoAlbumExample.setOrderByClause("id desc");
        return photoAlbumMapper.selectByExample(photoAlbumExample);
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

    // 分页查询
    @Override
    public Pagination queryAllPage(PhotoAlbumParam param){
        Integer pageSize = param.getPageSize() != null ? param.getPageSize() : CommConst.PAGE_SIZE;
        Integer currentPage = param.getCurrentPage() != null ? param.getCurrentPage() : CommConst.CURRENT_PAGE;
        Pagination pagination = new Pagination(currentPage, pageSize);
        //开始查询
        PageHelper.startPage(currentPage, pageSize);
        List<PhotoAlbum> photoAlbumList = selectByExample(param);
        List<PhotoAlbumOutput> result = new ArrayList<>();
        for (PhotoAlbum p:photoAlbumList) {
            PhotoAlbumOutput paOutput = new PhotoAlbumOutput(p);
            PhotoAlbumImageParam photoAlbumImageParam = new PhotoAlbumImageParam();
            photoAlbumImageParam.setPetId(p.getPetId());
            photoAlbumImageParam.setPhotoAlbumId(p.getId());
            List<PhotoAlbumImage> photoAlbumImageList = photoAlbumImageServiceI.selectByExample(photoAlbumImageParam);
            paOutput.setPhotoAlbumImageList(photoAlbumImageList);
            result.add(paOutput);
        }
        PageInfo<PhotoAlbumOutput> pageInfo = new PageInfo(result);
        pagination.setCount((int) pageInfo.getTotal());
        pagination.setData(result);
        return pagination;
    }
}
