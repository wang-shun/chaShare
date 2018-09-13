package com.holley.common.constants.charge;

/**
 * 充电交易状态<br>
 */
public enum ChargeDealStatusEnum {
    DEALING(1, "交易中"), SUCCESS(2, "成功"), FAILURE(3, "失败"), DEL(4, "已删除");

    private final int    value;
    private final String text;

    ChargeDealStatusEnum(int value, String text) {
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
        ChargeDealStatusEnum task = getEnmuByValue(value);
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
    public static ChargeDealStatusEnum getEnmuByValue(int value) {
        for (ChargeDealStatusEnum record : ChargeDealStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
