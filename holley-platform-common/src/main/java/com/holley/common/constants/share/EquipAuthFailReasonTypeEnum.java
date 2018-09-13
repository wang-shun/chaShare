package com.holley.common.constants.share;

/**
 * 获取token失败原因
 */
public enum EquipAuthFailReasonTypeEnum {
    NIL(0, "无"), UN_READY(1, "此设备尚未插枪"), FAIL(2, "设备检测失败"), UNKNOWN_EQUIP(3, "未知设备");

    private final int    value;
    private final String text;

    EquipAuthFailReasonTypeEnum(int value, String text) {
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
        EquipAuthFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static EquipAuthFailReasonTypeEnum getEnmuByValue(int value) {
        for (EquipAuthFailReasonTypeEnum record : EquipAuthFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
