package com.holley.common.constants.charge;

/**
 * 告警等级 <br>
 */
public enum AlarmLevelEnum {
                            GENERAL(1, "普通告警"), SERIOUS(2, "严重告警"), UNKNOWN(3, "未知告警");

    private final int    value;
    private final String text;

    AlarmLevelEnum(int value, String text) {
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
        AlarmLevelEnum task = getEnmuByValue(value);
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
    public static AlarmLevelEnum getEnmuByValue(int value) {
        for (AlarmLevelEnum record : AlarmLevelEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
