package com.holley.common.constants.charge;

/**
 * 业务类型 <br>
 */
public enum BusinessTypeEnum {
                              CHARGE(1, "充电");

    private final int    value;
    private final String text;

    BusinessTypeEnum(int value, String text) {
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
        BusinessTypeEnum task = getEnmuByValue(value);
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
    public static BusinessTypeEnum getEnmuByValue(int value) {
        for (BusinessTypeEnum record : BusinessTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
