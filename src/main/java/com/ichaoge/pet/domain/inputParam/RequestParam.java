package com.ichaoge.pet.domain.inputParam;

import java.io.Serializable;

/**
 * Created by chaoge on 2018/8/28.
 */
public class RequestParam implements Serializable {
    private Integer pageSize;
    private Integer currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pageSize\":")
                .append(pageSize);
        sb.append(",\"currentPage\":")
                .append(currentPage);
        sb.append('}');
        return sb.toString();
    }
}
