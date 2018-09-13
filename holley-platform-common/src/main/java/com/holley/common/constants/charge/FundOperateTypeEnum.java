package com.holley.common.constants.charge;

/**
 * 资金操作类型<br>
 */
public enum FundOperateTypeEnum {
                                 RECHARGE(1, "充值"), CHARGING(2, "充电"), APPOINTMENT(3, "预约"), CASH(4, "提现");

    private final int    value;
    private final String text;

    FundOperateTypeEnum(int value, String text) {
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
        FundOperateTypeEnum task = getEnmuByValue(value);
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
    public static FundOperateTypeEnum getEnmuByValue(int value) {
        for (FundOperateTypeEnum record : FundOperateTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
