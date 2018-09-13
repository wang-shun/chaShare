package com.holley.common.constants.charge;

/**
 * 充电交易标识 <br>
 */
public enum ChargeDealSignEnum {
                                CPU_SUCCESS(0, "CPU卡成功"), CPU_FAILURE(1, "CPU卡失败"), M1_SUCCESS(2, "M1卡成功"), M1_FAILURE(3, "M1卡失败");

    private final int    value;
    private final String text;

    ChargeDealSignEnum(int value, String text) {
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
        ChargeDealSignEnum task = getEnmuByValue(value);
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
    public static ChargeDealSignEnum getEnmuByValue(int value) {
        for (ChargeDealSignEnum record : ChargeDealSignEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
