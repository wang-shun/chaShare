package com.holley.common.constants.share;

/**
 * 充电设备接口状态类型
 */
public enum ConnectorStatusTypeEnum {
    OFF_LINE(0, "离网"), IDLE(1, "空闲"), UN_CHARGING(2, "未充电"), CHARGING(3, "充电中"), APPOINTMENT(4, "预约中"), FAULT(255, "故障");

    private final int    value;
    private final String text;

    ConnectorStatusTypeEnum(int value, String text) {
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
        ConnectorStatusTypeEnum task = getEnmuByValue(value);
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
    public static ConnectorStatusTypeEnum getEnmuByValue(int value) {
        for (ConnectorStatusTypeEnum record : ConnectorStatusTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
