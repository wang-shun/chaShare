package com.holley.common.constants.charge;


/**
 * 充电卡类型 <br>
 */
public enum ChargeCardTypeEnum {
    PERSON_CARD(1, "用户卡"), PLATFORM_CARD(2, "用户管理卡");

    private final int    value;
    private final String text;

    ChargeCardTypeEnum(int value, String text) {
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
        ChargeCardTypeEnum task = getEnmuByValue(value);
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
    public static ChargeCardTypeEnum getEnmuByValue(int value) {
        for (ChargeCardTypeEnum record : ChargeCardTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
