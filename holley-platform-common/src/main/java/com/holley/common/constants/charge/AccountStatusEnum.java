package com.holley.common.constants.charge;

/**
 * 账户状态 <br>
 */
public enum AccountStatusEnum {
                               ACTIVATED(1, "激活"), BLOCKED(2, "冻结");

    private final int    value;
    private final String text;

    AccountStatusEnum(int value, String text) {
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
        AccountStatusEnum task = getEnmuByValue(value);
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
    public static AccountStatusEnum getEnmuByValue(int value) {
        for (AccountStatusEnum record : AccountStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
