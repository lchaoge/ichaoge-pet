package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/21.
 */
public class PhotoAlbumParam extends BaseParam implements Serializable {
    private Long id;

    private Long petId;

    private Integer type;

    private String content;

    private Long labelSortId;

    private Date recordDate;

    private Integer recommend;

    private Integer status;

    private String creator;

    private Date created;

    private Date modified;

    private String[] photoAlbumImageList;

    private String[] labelSortList;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLabelSortId() {
        return labelSortId;
    }

    public void setLabelSortId(Long labelSortId) {
        this.labelSortId = labelSortId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
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

    public String[] getPhotoAlbumImageList() {
        return photoAlbumImageList;
    }

    public void setPhotoAlbumImageList(String[] photoAlbumImageList) {
        this.photoAlbumImageList = photoAlbumImageList;
    }

    public String[] getLabelSortList() {
        return labelSortList;
    }

    public void setLabelSortList(String[] labelSortList) {
        this.labelSortList = labelSortList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"petId\":\"").append(petId).append('\"');
        sb.append("\"type\":\"").append(type).append('\"');
        sb.append("\"content\":\"").append(content).append('\"');
        sb.append("\"labelSortId\":\"").append(labelSortId).append('\"');
        sb.append("\"recordDate\":\"").append(recordDate).append('\"');
        sb.append("\"recommend\":\"").append(recommend).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append("\"photoAlbumImageList\":\"").append(photoAlbumImageList).append('\"');
        sb.append("\"labelSortList\":\"").append(labelSortList).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
