package com.holley.charging.share.util;

import java.lang.reflect.Field;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class WechatConfig {

    public static String appid            = "wxf6aafe068889931b";                                         // 微信开放平台审核通过的应用APPID
    public static String mch_id           = "1357957402";                                                 // 微信支付分配的商户号
    public static String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";             // 统一下单的接口地址
    public static String method           = "POST";
    public static String notify_url       = "http://183.129.224.70:4880/evcs/pay/pay_wechatNotify.action";

    public static SortedMap<String, Object> objectToTreeMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        SortedMap<String, Object> map = new TreeMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    /**
     * 不定参数校验空
     * 
     * @param args
     * @return
     */
    public static boolean isNull(String... args) {
        for (String arg : args) {
            if (StringUtils.isEmpty(arg)) {
                return true;
            }
        }
        return false;
    }
}
