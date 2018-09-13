package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 实名认证审核状态 <br>
 */
public enum BusRealVerifyStatusEnum {
                                     UNVERIFIED(1, "未审核"), TRANSFERING(2, "转账中"), UNCHECKED(3, "待校验"), CHECK_PASSED(4, "校验成功"), CHECK_FAILED(5, "校验失败"), VERIFY_FAILED(6, "审核失败");

    private final int    value;
    private final String text;

    BusRealVerifyStatusEnum(int value, String text) {
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
        BusRealVerifyStatusEnum task = getEnmuByValue(value);
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
    public static BusRealVerifyStatusEnum getEnmuByValue(int value) {
        for (BusRealVerifyStatusEnum record : BusRealVerifyStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    /**
     * 获取审核状态
     * 
     * @return
     */
    public static List<BusRealVerifyStatusEnum> getRealVerifyResultList() {
        List<BusRealVerifyStatusEnum> list = new ArrayList<BusRealVerifyStatusEnum>();
        list.add(BusRealVerifyStatusEnum.TRANSFERING);
        list.add(BusRealVerifyStatusEnum.VERIFY_FAILED);
        return list;
    }

    /**
     * 获取转账状态
     * 
     * @return
     */
    public static List<BusRealVerifyStatusEnum> getRealTransferResultList() {
        List<BusRealVerifyStatusEnum> list = new ArrayList<BusRealVerifyStatusEnum>();
        list.add(BusRealVerifyStatusEnum.UNCHECKED);
        list.add(BusRealVerifyStatusEnum.VERIFY_FAILED);
        return list;
    }
}
