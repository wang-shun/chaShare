package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

import com.holley.common.dataobject.ComboxBean;

/**
 * 充电功率类型 <br>
 */
public enum ChargePowerTypeEnum {
                                 FAST(1, "快充"), SLOW(2, "慢充"), OVERSPEED(3, "超速");

    private final int    value;
    private final String text;

    ChargePowerTypeEnum(int value, String text) {
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
        ChargePowerTypeEnum task = getEnmuByValue(value);
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
    public static ChargePowerTypeEnum getEnmuByValue(int value) {
        for (ChargePowerTypeEnum record : ChargePowerTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<ComboxBean> getBeanList() {
        ComboxBean bean;
        List<ComboxBean> list = new ArrayList<ComboxBean>();
        for (ChargePowerTypeEnum record : ChargePowerTypeEnum.values()) {
            bean = new ComboxBean();
            bean.setKey(record.getValue() + "");
            bean.setValue(record.getText());
            list.add(bean);
        }
        return list;
    }
}
