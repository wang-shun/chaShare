package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备审核状态<br>
 */
public enum DeviceVerifyStatusEnum {
                                    UNVERIFIED(1, "待审核"), VERIFYING(2, "审核中"), PASSED(3, "审核通过"), FAILED(4, "审核不通过"), CANCEL(7, "取消");

    private final int    value;
    private final String text;

    DeviceVerifyStatusEnum(int value, String text) {
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
        DeviceVerifyStatusEnum task = getEnmuByValue(value);
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
    public static DeviceVerifyStatusEnum getEnmuByValue(int value) {
        for (DeviceVerifyStatusEnum record : DeviceVerifyStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<DeviceVerifyStatusEnum> getVerifyStatusList() {
        List<DeviceVerifyStatusEnum> list = new ArrayList<DeviceVerifyStatusEnum>();
        list.add(DeviceVerifyStatusEnum.UNVERIFIED);
        list.add(DeviceVerifyStatusEnum.VERIFYING);
        list.add(DeviceVerifyStatusEnum.PASSED);
        list.add(DeviceVerifyStatusEnum.FAILED);
        return list;
    }

    public static List<DeviceVerifyStatusEnum> getVerifyResultList() {
        List<DeviceVerifyStatusEnum> list = new ArrayList<DeviceVerifyStatusEnum>();
        list.add(DeviceVerifyStatusEnum.PASSED);
        list.add(DeviceVerifyStatusEnum.FAILED);
        return list;
    }
}
