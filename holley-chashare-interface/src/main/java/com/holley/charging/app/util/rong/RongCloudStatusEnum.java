package com.holley.charging.app.util.rong;

/**
 * 融云返回的状态<br>
 */
public enum RongCloudStatusEnum {
                                 SUCCESS(200, "成功");

    private final int    value;
    private final String text;

    RongCloudStatusEnum(int value, String text) {
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
        RongCloudStatusEnum task = getEnmuByValue(value);
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
    public static RongCloudStatusEnum getEnmuByValue(int value) {
        for (RongCloudStatusEnum record : RongCloudStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
