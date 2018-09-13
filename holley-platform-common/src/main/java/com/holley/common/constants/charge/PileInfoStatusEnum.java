package com.holley.common.constants.charge;

/**
 * 充电桩档案状态 <br>
 */
public enum PileInfoStatusEnum {
                                NORMAL(1, "正常"), FAULT(2, "故障"), REPAIR(3, "维护"), DEL(4, "删除");

    private final int    value;
    private final String text;

    PileInfoStatusEnum(int value, String text) {
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
        PileInfoStatusEnum task = getEnmuByValue(value);
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
    public static PileInfoStatusEnum getEnmuByValue(int value) {
        for (PileInfoStatusEnum record : PileInfoStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

}
