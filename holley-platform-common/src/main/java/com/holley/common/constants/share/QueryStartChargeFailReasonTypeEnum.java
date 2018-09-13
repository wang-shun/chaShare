package com.holley.common.constants.share;

/**
 * Description: 请求启动充电结果
 *
 * @author shen.cheng@holley.cn
 */
public enum QueryStartChargeFailReasonTypeEnum {
    NIL(0, "无"), UNKNOWN_EQUIP(1, "未知设备"), EQUIP_UNLINE(2, "设备离线");

    private final int    value;
    private final String text;

    QueryStartChargeFailReasonTypeEnum(int value, String text) {
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
        QueryStartChargeFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static QueryStartChargeFailReasonTypeEnum getEnmuByValue(int value) {
        for (QueryStartChargeFailReasonTypeEnum record : QueryStartChargeFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
