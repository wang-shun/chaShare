package com.holley.common.constants.share;

/**
 * 1.启动中2.充电中3.停止中4.已结束5.未知
 */
public enum StartChargeSeqStatEnum {
    STRTING(1, "启动中"), CHARGING(2, "充电中"), STOPING(3, "停止中"), END(4, "已结束"), UNKNOWN(5, "未知");

    private final int    value;
    private final String text;

    StartChargeSeqStatEnum(int value, String text) {
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
        StartChargeSeqStatEnum task = getEnmuByValue(value);
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
    public static StartChargeSeqStatEnum getEnmuByValue(int value) {
        for (StartChargeSeqStatEnum record : StartChargeSeqStatEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
