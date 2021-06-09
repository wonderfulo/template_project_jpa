package com.cxy.constant;

/**
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
public enum IsDeleteEnum {
    /**
     * 保留
     */
    FALSE(0,"保留"),

    /**
     * 删除
     */
    TRUE(1,"删除");

    /**
     * 值
     */
    private final int value;

    /**
     * 名称
     */
    private final String name;

    IsDeleteEnum(int value,String name){
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
