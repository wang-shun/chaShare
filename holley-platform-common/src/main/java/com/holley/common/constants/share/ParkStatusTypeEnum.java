package com.holley.common.constants.share;

/**
 * 停车位状态
 */
public enum ParkStatusTypeEnum {
    UNKNOWN(0, "未知"), IDLE(1, "空闲"), USING(2, "占用");

    private final int    value;
    private final String text;

    ParkStatusTypeEnum(int value, String text) {
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
        ParkStatusTypeEnum task = getEnmuByValue(value);
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
    public static ParkStatusTypeEnum getEnmuByValue(int value) {
        for (ParkStatusTypeEnum record : ParkStatusTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
