package com.ichaoge.pet.domain.entity.enums;

/**
 * Created by chaoge on 2018/9/26.
 */
public enum LabelTypeEnums {
//    类型：1：日常，2：用品，3：食品，4：健康护理
    DAILY(1, "日常"),
    APPLIANCE(2, "用品"),
    FOOD(3, "食品"),
    HEALTHCARE(4, "健康护理");

    private int value;
    private String desc;

    private LabelTypeEnums(int value, String desc) {
        this.desc = desc;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
