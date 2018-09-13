package com.holley.common.constants.charge;

/**
 * 对账争议原因 <br>
 */
public enum DisputeReasonEnum {
    NO_TRADER(1, "交易不存在"), BAD_MONEY(2, "交易金额有误"), BAD_POWER(3, "交易电量有误");

    private final int    value;
    private final String text;

    DisputeReasonEnum(int value, String text) {
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
        DisputeReasonEnum task = getEnmuByValue(value);
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
    public static DisputeReasonEnum getEnmuByValue(int value) {
        for (DisputeReasonEnum record : DisputeReasonEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
