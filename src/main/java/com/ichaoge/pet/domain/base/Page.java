package com.ichaoge.pet.domain.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by red on 2016/2/14.
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Integer pageNo;

    private transient Integer pageSize;

    private transient String orderByClause;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Map<String, Integer> getPageParam(){
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("pageNo", this.pageNo);
        params.put("pageSize", this.pageSize);

        return params;
    }
}
