package com.holley.common.constants.charge;

/**
 * 充电桩预约状态 <br>
 */
public enum PileAppStatusEnum {
    UNORDERED(1, "未预约"), UNORDERABLE(2, "不可预约"), ORDER_REQUEST(3, "请求预约"), ORDER_SUCCESS(4, "预约成功"), ORDER_FAILED(5, "预约失败");

    private final int    value;
    private final String text;

    PileAppStatusEnum(int value, String text) {
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
        PileAppStatusEnum task = getEnmuByValue(value);
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
    public static PileAppStatusEnum getEnmuByValue(int value) {
        for (PileAppStatusEnum record : PileAppStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
