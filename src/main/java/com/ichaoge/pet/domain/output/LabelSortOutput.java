package com.ichaoge.pet.domain.output;

import com.ichaoge.pet.domain.entity.LabelSort;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chaoge on 2018/9/22.
 */
public class LabelSortOutput implements Serializable {

    private Integer type;

    private String typeName;

    private List<com.ichaoge.pet.domain.output.LabelSort> labelSorts;

    public LabelSortOutput() {

    }

    public LabelSortOutput(Integer type, String typeName, List<com.ichaoge.pet.domain.output.LabelSort> labelSorts) {
        this.type = type;
        this.typeName = typeName;
        this.labelSorts = labelSorts;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<com.ichaoge.pet.domain.output.LabelSort> getLabelSorts() {
        return labelSorts;
    }

    public void setLabelSorts(List<com.ichaoge.pet.domain.output.LabelSort> labelSorts) {
        this.labelSorts = labelSorts;
    }
}
