package com.holley.common.constants.charge;

/**
 * 充电接口类型 <br>
 */
public enum ChargeInterfaceTypeEnum {
                                     GB_AC(1, "国标交流"), GB_DC(2, "国标直流");

    private final int    value;
    private final String text;

    ChargeInterfaceTypeEnum(int value, String text) {
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
        ChargeInterfaceTypeEnum task = getEnmuByValue(value);
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
    public static ChargeInterfaceTypeEnum getEnmuByValue(int value) {
        for (ChargeInterfaceTypeEnum record : ChargeInterfaceTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
