package com.holley.common.constants.charge;

public enum LinkTypeEnum {
    CHA_WAY("CHA_WAY", "充电桩类型"), COM_TYPE("COM_TYPE", "通讯协议"), IS_NO("IS_NO", "是否值"), PARK_TYPE("PARK_TYPE", "停车场类型"), PAY_WAY("PAY_WAY", "支付方式"),
    PILE_TYPE("PILE_TYPE", "充电功率类型"), BUS_TYPE("BUS_TYPE", "运营类型"), BUS_DOMAIN("BUS_DOMAIN", "主营业务"), BANK_NAME("BANK_NAME", "银行名称"), OPEN_DAY("OPEN_DAY", "开放日"),
    OPEN_TIME("OPEN_TIME", "开放时间"), INTF_TYPE("INTF_TYPE", "充电接口类型"), VALID_TYPE("VALID_TYPE", "审核类型"), REQUEST_TYPE("REQUEST_TYPE", "设备归档请求类型"), APPMENT_STATUS("APPMENT_STATUS",
                                                                                                                                                                 "预约状态类型"),
    DEAL_STATUS("DEAL_STATUS", "充电交易状态"), IOS_VERSION("IOS_VERSION", "IOS版本号"), ANDROID_VERSION("ANDROID_VERSION", "ANDROID版本号"), SCALE_TYPE("SCALE_TYPE", "企业/集团规模"),
    COM_SUB_ADDR("COM_SUB_ADDR", "充电桩子通讯地址");

    private final String value;
    private final String text;

    LinkTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String value) {
        LinkTypeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static LinkTypeEnum getEnmuByValue(String value) {
        for (LinkTypeEnum record : LinkTypeEnum.values()) {
            if (value.equals(record.getValue())) {
                return record;
            }
        }
        return null;
    }
}
