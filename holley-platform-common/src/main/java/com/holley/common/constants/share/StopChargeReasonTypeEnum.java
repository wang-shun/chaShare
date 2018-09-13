package com.holley.common.constants.share;

/**
 * Description: 充电结束原因
 *
 * @author shen.cheng@holley.cn
 */
public enum StopChargeReasonTypeEnum {
    MANUAL(0, "手动停止"), APP(1, "客户归属地运营商平台停止充电"), BMS(2, "BMS停止充电"), EQUIP_FAULT(3, "设备故障"), EQUIP_CUT(4, "连接器断开");

    private final int    value;
    private final String text;

    StopChargeReasonTypeEnum(int value, String text) {
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
        StopChargeReasonTypeEnum task = getEnmuByValue(value);
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
    public static StopChargeReasonTypeEnum getEnmuByValue(int value) {
        for (StopChargeReasonTypeEnum record : StopChargeReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
