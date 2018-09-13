package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 开票状态 <br>
 */
public enum BillStatusEnum {
                            VERIFYING(1, "审核中"), SUCCESS(2, "开票成功"), FAILURE(3, "开票失败");

    private final int    value;
    private final String text;

    BillStatusEnum(int value, String text) {
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
        BillStatusEnum task = getEnmuByValue(value);
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
    public static BillStatusEnum getEnmuByValue(int value) {
        for (BillStatusEnum record : BillStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<BillStatusEnum> getVerifyResultList() {
        List<BillStatusEnum> list = new ArrayList<BillStatusEnum>();
        list.add(BillStatusEnum.SUCCESS);
        list.add(BillStatusEnum.FAILURE);
        return list;
    }
}
