package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/25.
 */
public class PhotoAlbumImageParam extends BaseParam implements Serializable {
    private Long id;

    private Long petId;

    private Long photoAlbumId;

    private String imageUrl;

    private String title;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"petId\":\"").append(petId).append('\"');
        sb.append("\"photoAlbumId\":\"").append(photoAlbumId).append('\"');
        sb.append("\"imageUrl\":\"").append(imageUrl).append('\"');
        sb.append("\"title\":\"").append(title).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append('}');
        return sb.toString();
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

    public Long getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Long photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
