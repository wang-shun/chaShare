package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 提现审核状态 <br>
 */
public enum CashVerifyStatusEnum {
                                  VERIFYING(1, "审核中"), PASSED(2, "审核通过"), FAILED(3, "审核未通过");

    private final int    value;
    private final String text;

    CashVerifyStatusEnum(int value, String text) {
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
        CashVerifyStatusEnum task = getEnmuByValue(value);
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
    public static CashVerifyStatusEnum getEnmuByValue(int value) {
        for (CashVerifyStatusEnum record : CashVerifyStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<CashVerifyStatusEnum> getVerifyResultList() {
        List<CashVerifyStatusEnum> list = new ArrayList<CashVerifyStatusEnum>();
        list.add(CashVerifyStatusEnum.PASSED);
        list.add(CashVerifyStatusEnum.FAILED);
        return list;
    }
}
