package com.holley.common.constants.charge;

public enum AccountLogTypeEnum {
    RECHARGE(1, "充值"), ACC_CHARGING(2, "平台账户充电"), UNACC_CHARGING(3, "非平台账户充电"), ACC_APPOINTMENT(4, "平台账户预约"), UNACC_APPOINTMENT(5, "非平台账户预约"), APPLY_CASH(6, "申请提现"),
    VALID_CASH(7, "审核提现"), BILL(8, "结算"), CARD_RECHARGE(9, "充电卡充值"), CARD_CUT_MONEY(10, "充电卡扣款"), CARD_CHARGING(11, "充电卡充电");

    private final int    value;
    private final String text;

    AccountLogTypeEnum(int value, String text) {
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
        AccountLogTypeEnum task = getEnmuByValue(value);
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
    public static AccountLogTypeEnum getEnmuByValue(int value) {
        for (AccountLogTypeEnum record : AccountLogTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
