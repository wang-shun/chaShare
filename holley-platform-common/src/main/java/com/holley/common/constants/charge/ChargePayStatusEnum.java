package com.holley.common.constants.charge;

/**
 * 充电支付状态 <br>
 */
public enum ChargePayStatusEnum {
                                 UNPAID(1, "未缴费"), PAYING(2, "缴费中"), SUCCESS(3, "缴费成功"), FAILURE(4, "缴费失败");

    private final int    value;
    private final String text;

    ChargePayStatusEnum(int value, String text) {
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
        ChargePayStatusEnum task = getEnmuByValue(value);
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
    public static ChargePayStatusEnum getEnmuByValue(int value) {
        for (ChargePayStatusEnum record : ChargePayStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
