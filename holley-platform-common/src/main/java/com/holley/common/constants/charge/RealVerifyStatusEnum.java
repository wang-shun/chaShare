package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 实名认证审核状态 <br>
 */
public enum RealVerifyStatusEnum {
                                  VERIFYING(1, "审核中"), PASSED(2, "审核通过"), FAILED(3, "审核失败");

    private final int    value;
    private final String text;

    RealVerifyStatusEnum(int value, String text) {
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
        RealVerifyStatusEnum task = getEnmuByValue(value);
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
    public static RealVerifyStatusEnum getEnmuByValue(int value) {
        for (RealVerifyStatusEnum record : RealVerifyStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<RealVerifyStatusEnum> getVerifyResultList() {
        List<RealVerifyStatusEnum> list = new ArrayList<RealVerifyStatusEnum>();
        list.add(RealVerifyStatusEnum.PASSED);
        list.add(RealVerifyStatusEnum.FAILED);
        return list;
    }
}
