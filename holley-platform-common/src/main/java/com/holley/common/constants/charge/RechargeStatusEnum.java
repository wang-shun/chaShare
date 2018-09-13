package com.holley.common.constants.charge;

/**
 * 充值状态 <br>
 */
public enum RechargeStatusEnum {
                                RECHARGING(1, "充值中"), SUCCESS(2, "成功"), FAILURE(3, "失败");

    private final int    value;
    private final String text;

    RechargeStatusEnum(int value, String text) {
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
        RechargeStatusEnum task = getEnmuByValue(value);
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
    public static RechargeStatusEnum getEnmuByValue(int value) {
        for (RechargeStatusEnum record : RechargeStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
