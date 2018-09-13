package com.holley.common.constants.charge;

/**
 * 性别 <br>
 */
public enum SexEnum {
                     MALE(1, "男"), FEMALE(2, "女");

    private final int    value;
    private final String text;

    SexEnum(int value, String text) {
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
        SexEnum task = getEnmuByValue(value);
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
    public static SexEnum getEnmuByValue(int value) {
        for (SexEnum record : SexEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
