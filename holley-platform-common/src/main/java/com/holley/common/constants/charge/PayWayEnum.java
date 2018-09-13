package com.holley.common.constants.charge;

/**
 * 支付方式 <br>
 */
public enum PayWayEnum {
    ACCOUNT(1, "资金账户"), ALIPAY(2, "支付宝"), WECHAT(3, "微信"), UNIONPAY(4, "银联"), CREDITCARD(5, "信用卡"), CACH(6, "现金"), SYSTEM(7, "系统后台"), EC_APP(8, "e充网");

    private final int    value;
    private final String text;

    PayWayEnum(int value, String text) {
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
        PayWayEnum task = getEnmuByValue(value);
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
    public static PayWayEnum getEnmuByValue(int value) {
        for (PayWayEnum record : PayWayEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
