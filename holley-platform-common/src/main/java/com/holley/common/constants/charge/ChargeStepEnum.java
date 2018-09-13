package com.holley.common.constants.charge;

/**
 * 账户状态 <br>
 */
public enum ChargeStepEnum {
    START(1, "启动"), DO(2, "充电中"), END(3, "充电结束"), STOP(4, "手动停止"), CLOSE(5, "支付结果推送");

    private final int    value;
    private final String text;

    ChargeStepEnum(int value, String text) {
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
        ChargeStepEnum task = getEnmuByValue(value);
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
    public static ChargeStepEnum getEnmuByValue(int value) {
        for (ChargeStepEnum record : ChargeStepEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
