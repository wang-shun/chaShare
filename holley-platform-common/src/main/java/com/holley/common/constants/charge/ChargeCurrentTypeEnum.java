package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

import com.holley.common.dataobject.ComboxBean;

/**
 * 充电电流类型 <br>
 */
public enum ChargeCurrentTypeEnum {
                                   AC(1, "交流"), DC(2, "直流");

    private final int    value;
    private final String text;

    ChargeCurrentTypeEnum(int value, String text) {
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
        ChargeCurrentTypeEnum task = getEnmuByValue(value);
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
    public static ChargeCurrentTypeEnum getEnmuByValue(int value) {
        for (ChargeCurrentTypeEnum record : ChargeCurrentTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<ComboxBean> getBeanList() {
        ComboxBean bean;
        List<ComboxBean> list = new ArrayList<ComboxBean>();
        for (ChargeCurrentTypeEnum record : ChargeCurrentTypeEnum.values()) {
            bean = new ComboxBean();
            bean.setKey(record.getValue() + "");
            bean.setValue(record.getText());
            list.add(bean);
        }
        return list;
    }
}
