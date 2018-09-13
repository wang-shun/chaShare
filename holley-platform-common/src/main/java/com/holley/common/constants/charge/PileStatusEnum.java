package com.holley.common.constants.charge;

/**
 * 充电桩运行状态 <br>
 */
public enum PileStatusEnum {
                            IDLE(1, "空闲"), BUSYING(2, "忙碌中"), CHARGING(3, "充电中"), FINISH(4, "充电完成"), FAULT(5, "故障"), OFFLINE(6, "离线");

    private final int    value;
    private final String text;

    PileStatusEnum(int value, String text) {
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
        PileStatusEnum task = getEnmuByValue(value);
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
    public static PileStatusEnum getEnmuByValue(int value) {
        for (PileStatusEnum record : PileStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
