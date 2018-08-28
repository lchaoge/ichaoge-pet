package com.ichaoge.pet.domain.entity.enums;

/**
 * 共用stutes
 *
 */
public enum StatusEnums {
    EFFICIENT(1, "生效的"),
    DISABLED(0, "失效的"),
    INPUTED(2,"已导入"),
    CANEDIT(3,"可修改"),
    CLOSED(4,"已关闭");

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
