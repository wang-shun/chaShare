package com.holley.common.constants.charge;

/**
 * 充电桩型号状态 <br>
 */
public enum PileModelStatusEnum {
                                 VALID(1, "有效"), INVALID(2, "无效");

    private final int    value;
    private final String text;

    PileModelStatusEnum(int value, String text) {
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
        PileModelStatusEnum task = getEnmuByValue(value);
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
    public static PileModelStatusEnum getEnmuByValue(int value) {
        for (PileModelStatusEnum record : PileModelStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
