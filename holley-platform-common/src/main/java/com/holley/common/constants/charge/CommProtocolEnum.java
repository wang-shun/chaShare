package com.holley.common.constants.charge;

/**
 * 通讯协议<br>
 */
public enum CommProtocolEnum {
                              GW(1, "国网");

    private final int    value;
    private final String text;

    CommProtocolEnum(int value, String text) {
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
        CommProtocolEnum task = getEnmuByValue(value);
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
    public static CommProtocolEnum getEnmuByValue(int value) {
        for (CommProtocolEnum record : CommProtocolEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
