package com.holley.common.constants.share;

/**
 * 命令类型（前置通讯）
 */
public enum ComTypeEnum {
    START_CHARGE(1, "启动充电"), STOP_CHARGE(2, "停止充电");

    private final int    value;
    private final String text;

    ComTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        ComTypeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static ComTypeEnum getEnmuByValue(int value) {
        for (ComTypeEnum record : ComTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
