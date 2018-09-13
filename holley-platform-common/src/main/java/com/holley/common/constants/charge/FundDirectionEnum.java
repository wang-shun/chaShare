package com.holley.common.constants.charge;

/**
 * 资金流向 <br>
 */
public enum FundDirectionEnum {
    IN(1, "收入"), OUT(2, "支出"), NO(3, "不变");

    private final int    value;
    private final String text;

    FundDirectionEnum(int value, String text) {
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
        FundDirectionEnum task = getEnmuByValue(value);
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
    public static FundDirectionEnum getEnmuByValue(int value) {
        for (FundDirectionEnum record : FundDirectionEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
