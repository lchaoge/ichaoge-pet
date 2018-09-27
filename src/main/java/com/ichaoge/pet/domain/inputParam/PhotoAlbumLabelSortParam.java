package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/26.
 */
public class PhotoAlbumLabelSortParam extends BaseParam implements Serializable {

    private Long id;

    private Long photoAlbumId;

    private Long labelSortId;

    private Date created;

    private Date modified;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"photoAlbumId\":\"").append(photoAlbumId).append('\"');
        sb.append("\"labelSortId\":\"").append(labelSortId).append('\"');
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

    public Long getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Long photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public Long getLabelSortId() {
        return labelSortId;
    }

    public void setLabelSortId(Long labelSortId) {
        this.labelSortId = labelSortId;
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
