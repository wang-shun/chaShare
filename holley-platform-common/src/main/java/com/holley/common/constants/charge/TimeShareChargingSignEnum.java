package com.holley.common.constants.charge;

/**
 * 分时计费标志 <br>
 */
public enum TimeShareChargingSignEnum {
                                       TIMESHARE(0, "分时"), SINGLE(1, "不分时");

    private final int    value;
    private final String text;

    TimeShareChargingSignEnum(int value, String text) {
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
        TimeShareChargingSignEnum task = getEnmuByValue(value);
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
    public static TimeShareChargingSignEnum getEnmuByValue(int value) {
        for (TimeShareChargingSignEnum record : TimeShareChargingSignEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
