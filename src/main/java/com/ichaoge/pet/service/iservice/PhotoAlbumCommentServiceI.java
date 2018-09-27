package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.entity.PhotoAlbumCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/27.
 */
public interface PhotoAlbumCommentServiceI {

    int countByExample(PhotoAlbumCommentExample example);

    int deleteByExample(PhotoAlbumCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumComment record);

    int insertSelective(PhotoAlbumComment record);

    List<PhotoAlbumComment> selectByExampleWithBLOBs(PhotoAlbumCommentExample example);

    List<PhotoAlbumComment> selectByExample(PhotoAlbumCommentExample example);

    PhotoAlbumComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbumComment record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbumComment record);

    int updateByPrimaryKey(PhotoAlbumComment record);
}
