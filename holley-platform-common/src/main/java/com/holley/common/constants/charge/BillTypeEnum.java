package com.holley.common.constants.charge;

/**
 * 发票类型 <br>
 */
public enum BillTypeEnum {
                          COMMON(1, "普通发票"), ADDED(2, "增值发票");

    private final int    value;
    private final String text;

    BillTypeEnum(int value, String text) {
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
        BillTypeEnum task = getEnmuByValue(value);
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
    public static BillTypeEnum getEnmuByValue(int value) {
        for (BillTypeEnum record : BillTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
