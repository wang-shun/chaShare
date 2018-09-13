package com.holley.common.constants.charge;

/**
 * 充电方式 <br>
 */
public enum ChargeWayEnum {
                           APP(0, "APP"), CARD(1, "充电卡"), MANUAL(2, "人工");

    private final int    value;
    private final String text;

    ChargeWayEnum(int value, String text) {
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
        ChargeWayEnum task = getEnmuByValue(value);
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
    public static ChargeWayEnum getEnmuByValue(int value) {
        for (ChargeWayEnum record : ChargeWayEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
