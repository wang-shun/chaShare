package com.holley.common.constants.app;

/**
 * APP类型 <br>
 */
public enum AppTypeEnum {
                         ANDROID(1, "ANDROID"), IOS(2, "IOS");

    private final int    value;
    private final String text;

    AppTypeEnum(int value, String text) {
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
        AppTypeEnum task = getEnmuByValue(value);
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
    public static AppTypeEnum getEnmuByValue(int value) {
        for (AppTypeEnum record : AppTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
