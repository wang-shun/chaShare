package com.holley.common.constants;

/**
 * 生成账单类型 <br>
 */
public enum BillCycleTypeEnum {
    BYMONTH(1, "按月");

    private final int    value;
    private final String text;

    BillCycleTypeEnum(int value, String text) {
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
        BillCycleTypeEnum task = getEnmuByValue(value);
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
    public static BillCycleTypeEnum getEnmuByValue(int value) {
        for (BillCycleTypeEnum record : BillCycleTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
