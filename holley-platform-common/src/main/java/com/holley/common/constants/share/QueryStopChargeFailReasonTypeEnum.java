package com.holley.common.constants.share;

/**
 * Description: 请求停止充电结果
 *
 * @author shen.cheng@holley.cn
 */
public enum QueryStopChargeFailReasonTypeEnum {
    NIL(0, "无"), UNKNOWN_EQUIP(1, "未知设备"), EQUIP_UNLINE(2, "设备离线"), UN_CHARGE(3, "停止充电");

    private final int    value;
    private final String text;

    QueryStopChargeFailReasonTypeEnum(int value, String text) {
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
        QueryStopChargeFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static QueryStopChargeFailReasonTypeEnum getEnmuByValue(int value) {
        for (QueryStopChargeFailReasonTypeEnum record : QueryStopChargeFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
