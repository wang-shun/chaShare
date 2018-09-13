package com.holley.common.constants.charge;

import com.holley.common.util.StringUtil;

/**
 * 充电模式类型 <br>
 */
public enum ChargeModeEnum {
                            BY_AUTO(0, "自动"), BY_EQ(1, "电量"), BY_TIME(2, "时间"), BY_MONEY(3, "金额");

    private final int    value;
    private final String text;

    ChargeModeEnum(int value, String text) {
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
        ChargeModeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    public static String getDefaultText(Short value) {
        if (value == null) return "未知";
        String desc = getText(value.intValue());
        if (StringUtil.isEmpty(desc)) {
            desc = "未知";
        }
        return desc;
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
    public static ChargeModeEnum getEnmuByValue(int value) {
        for (ChargeModeEnum record : ChargeModeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
