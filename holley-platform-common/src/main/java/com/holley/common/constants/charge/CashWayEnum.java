package com.holley.common.constants.charge;

/**
 * 提现方式<br>
 */
public enum CashWayEnum {
                         ALIPAY(1, "支付宝"), UNIONPAY(2, "银联"), WECHAT(3, "微信钱包");

    private final int    value;
    private final String text;

    CashWayEnum(int value, String text) {
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
        CashWayEnum task = getEnmuByValue(value);
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
    public static CashWayEnum getEnmuByValue(int value) {
        for (CashWayEnum record : CashWayEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
