package com.holley.common.constants.charge;

/**
 * 预约支付状态 <br>
 */
public enum AppointmentPayStatusEnum {
                                      UNPAID(1, "未支付"), PAYING(2, "支付中"), SUCCESS(3, "支付成功"), FAILURE(4, "支付失败");

    private final int    value;
    private final String text;

    AppointmentPayStatusEnum(int value, String text) {
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
        AppointmentPayStatusEnum task = getEnmuByValue(value);
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
    public static AppointmentPayStatusEnum getEnmuByValue(int value) {
        for (AppointmentPayStatusEnum record : AppointmentPayStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
