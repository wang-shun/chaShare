package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 提现状态 <br>
 */
public enum CashStatusEnum {
                            WITHDRAWING(1, "提现中"), SUCCESS(2, "提现成功"), FAILURE(3, "提现失败");

    private final int    value;
    private final String text;

    CashStatusEnum(int value, String text) {
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
        CashStatusEnum task = getEnmuByValue(value);
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
    public static CashStatusEnum getEnmuByValue(int value) {
        for (CashStatusEnum record : CashStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<CashStatusEnum> getCashResultList() {
        List<CashStatusEnum> list = new ArrayList<CashStatusEnum>();
        list.add(CashStatusEnum.SUCCESS);
        list.add(CashStatusEnum.FAILURE);
        return list;
    }
}
