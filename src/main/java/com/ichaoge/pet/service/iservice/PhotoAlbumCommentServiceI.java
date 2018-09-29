package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.entity.PhotoAlbumCommentExample;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumCommentParam;
import com.ichaoge.pet.domain.output.CommentFloor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by chaoge on 2018/9/27.
 */
public interface PhotoAlbumCommentServiceI {

    int countByExample(PhotoAlbumCommentExample example);

    int deleteByExample(PhotoAlbumComment param);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumComment record);

    int insertSelective(PhotoAlbumComment record);

    List<PhotoAlbumComment> selectByExampleWithBLOBs(PhotoAlbumCommentExample param);

    List<PhotoAlbumComment> selectByExample(PhotoAlbumCommentParam param);

    PhotoAlbumComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbumComment record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbumComment record);

    int updateByPrimaryKey(PhotoAlbumComment record);

    // 查询当前评论的最后一个楼
    Long selectFloorByPhotoAlbumId(Long photoAlbumId);

    List<CommentFloor> selectAllFloor(Long photoAlbumId);
}
