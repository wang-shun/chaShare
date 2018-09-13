package com.holley.common.constants.charge;

/**
 * 预约状态 <br>
 */
public enum AppointmentStatusEnum {
                                   ORDERING(1, "预约中"), EXECUTED(2, "履约"), CANCEL(3, "取消"), OVERDUE(4, "过时"), DEL(5, "已删除"), RENEW(6, "被续约");

    private final int    value;
    private final String text;

    AppointmentStatusEnum(int value, String text) {
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
        AppointmentStatusEnum task = getEnmuByValue(value);
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
    public static AppointmentStatusEnum getEnmuByValue(int value) {
        for (AppointmentStatusEnum record : AppointmentStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
