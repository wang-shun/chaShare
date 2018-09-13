package com.holley.charging.share.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 微信支付签名
 */
public class WechatSignUtils {

    // http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
    // 商户Key：改成公司申请的即可
    // 32位密码设置地址：http://www.sexauth.com/ jdex1hvufnm1sdcb0e81t36k0d0f15nc
    private static String Key = "Holley51chargeapp201606270000001";

    /**
     * 微信支付签名算法sign
     * 
     * @param characterEncoding
     * @param parameters
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(String characterEncoding, SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + Key);
        System.out.println("字符串拼接后是：" + sb.toString());
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        System.out.println("sign：" + sign);
        return sign;
    }

}
