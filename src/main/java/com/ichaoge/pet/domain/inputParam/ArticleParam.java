package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/19.
 */
public class ArticleParam extends BaseParam implements Serializable {

    private Long id;

    private Long userId;

    private Long articleSortId;

    private Integer type;

    private Integer articleType;

    private String title;

    private Integer see;

    private String ip;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    private String content;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"userId\":\"").append(userId).append('\"');
        sb.append("\"articleSortId\":\"").append(articleSortId).append('\"');
        sb.append("\"type\":\"").append(type).append('\"');
        sb.append("\"articleType\":\"").append(articleType).append('\"');
        sb.append("\"title\":\"").append(title).append('\"');
        sb.append("\"see\":\"").append(see).append('\"');
        sb.append("\"ip\":\"").append(ip).append('\"');
        sb.append("\"content\":\"").append(content).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
