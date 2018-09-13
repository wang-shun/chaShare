package com.holley.common.constants;

public enum UseToTypeEnum {
    CAR(1, "汽车"), BIKE(2, "自行车");

    private final int    value;
    private final String text;

    UseToTypeEnum(int value, String text) {
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
        UseToTypeEnum task = getEnmuByValue(value);
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
    public static UseToTypeEnum getEnmuByValue(int value) {
        for (UseToTypeEnum record : UseToTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
