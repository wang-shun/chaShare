package com.holley.common.constants.share;

/**
 * 充电设备接口类型
 */
public enum ConnectorTypeEnum {
    HOUSEHOLD(1, "家用插座"), AC_SOCKET(2, "交流接口插座"), AC_PLUG(3, "交流接口插头"), DC_PLUG(4, "直流接口枪头"), WIRELESS_SOCKET(5, "无线充电座"), OTHER(6, "其他");

    private final int    value;
    private final String text;

    ConnectorTypeEnum(int value, String text) {
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
        ConnectorTypeEnum task = getEnmuByValue(value);
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
    public static ConnectorTypeEnum getEnmuByValue(int value) {
        for (ConnectorTypeEnum record : ConnectorTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
