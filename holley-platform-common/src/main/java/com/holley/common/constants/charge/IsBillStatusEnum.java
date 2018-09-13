package com.holley.common.constants.charge;

/**
 * 对账状态 <br>
 */
public enum IsBillStatusEnum {
    BILL(1, "已对账"), UN_BILL(2, "未对账"), PUSH(3, "已推送"), INVALID(4, "无效");

    private final int    value;
    private final String text;

    IsBillStatusEnum(int value, String text) {
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
        IsBillStatusEnum task = getEnmuByValue(value);
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
    public static IsBillStatusEnum getEnmuByValue(int value) {
        for (IsBillStatusEnum record : IsBillStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
