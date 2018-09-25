package com.ichaoge.pet.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class PhotoAlbumLabelSort implements Serializable {
    private Long id;

    private Long photoAlbumId;

    private Long labelSortId;

    private Date created;

    private Date modified;

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PhotoAlbumLabelSort other = (PhotoAlbumLabelSort) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()))
            && (this.getLabelSortId() == null ? other.getLabelSortId() == null : this.getLabelSortId().equals(other.getLabelSortId()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getModified() == null ? other.getModified() == null : this.getModified().equals(other.getModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        result = prime * result + ((getLabelSortId() == null) ? 0 : getLabelSortId().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getModified() == null) ? 0 : getModified().hashCode());
        return result;
    }
}