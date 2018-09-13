package com.holley.common.constants;

/**
 * 账单标志类型 <br>
 */
public enum BillMarkTypeEnum {
    CHARGE(1, "充电"), APPOINTMENT(2, "预约");

    private final int    value;
    private final String text;

    BillMarkTypeEnum(int value, String text) {
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
        BillMarkTypeEnum task = getEnmuByValue(value);
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
    public static BillMarkTypeEnum getEnmuByValue(int value) {
        for (BillMarkTypeEnum record : BillMarkTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
