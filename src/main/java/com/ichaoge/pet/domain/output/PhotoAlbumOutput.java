package com.ichaoge.pet.domain.output;

import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumImage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chaoge on 2018/9/25.
 */
public class PhotoAlbumOutput implements Serializable {
    private Long id;

    private Long petId;

    private Integer type;

    private Date recordDate;

    private Integer recommend;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    private String content;
    // 图片
    private List<PhotoAlbumImage> photoAlbumImageList;

    public PhotoAlbumOutput(PhotoAlbum photoAlbum){
        this.id = photoAlbum.getId();
        this.petId = photoAlbum.getId();
        this.type = photoAlbum.getType();
        this.recordDate = photoAlbum.getRecordDate();
        this.recommend = photoAlbum.getRecommend();
        this.status = photoAlbum.getStatus();
        this.creator = photoAlbum.getCreator();
        this.created = photoAlbum.getCreated();
        this.modified = photoAlbum.getModified();
        this.content = photoAlbum.getContent();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PhotoAlbumImage> getPhotoAlbumImageList() {
        return photoAlbumImageList;
    }

    public void setPhotoAlbumImageList(List<PhotoAlbumImage> photoAlbumImageList) {
        this.photoAlbumImageList = photoAlbumImageList;
    }
}
