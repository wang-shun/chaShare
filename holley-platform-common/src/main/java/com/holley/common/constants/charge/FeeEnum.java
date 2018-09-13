package com.holley.common.constants.charge;

/**
 * 费率类型 <br>
 */
public enum FeeEnum {
    ONE(1, "单一费率"), MORE(2, "多费率");

    private final int    value;
    private final String text;

    FeeEnum(int value, String text) {
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
        FeeEnum task = getEnmuByValue(value);
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
    public static FeeEnum getEnmuByValue(int value) {
        for (FeeEnum record : FeeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
