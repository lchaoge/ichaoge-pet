package com.ichaoge.pet.domain.entity.enums;

/**
 * 共用stutes
 * 状态 1：正常 0:异常
 */
public enum StatusEnums {

    EFFECTIVE(1, "正常"),
    INVALID(0, "异常");

    private int value;
    private String desc;

    private StatusEnums(int value, String desc) {
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
