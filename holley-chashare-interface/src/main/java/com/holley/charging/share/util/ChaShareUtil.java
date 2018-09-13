package com.holley.charging.share.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;

public class ChaShareUtil {

    private static String Key               = "2C3NFEWaaedTW1oFYrKL60pl2DCNb43V";
    private static String characterEncoding = "UTF-8";

    /**
     * @param characterEncoding
     * @param parameters
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(SortedMap<String, Object> parameters) {
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

    public static String createKeyValue(SortedMap<String, Object> parameters) {
        if (parameters == null || parameters.isEmpty()) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static SortedMap createParameters(Class clazz, Object obj) {
        Field[] fs = clazz.getDeclaredFields();
        SortedMap<String, Object> params = new TreeMap<String, Object>();
        if (fs != null && fs.length > 0) {
            for (Field f : fs) {
                try {
                    String key = f.getName();
                    String value = BeanUtils.getProperty(obj, key);
                    params.put(key, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return params;
    }

    public static void main(String[] args) {
        SortedMap<String, Object> params = new TreeMap<String, Object>();
        String[] keys = { "from", "seq", "sign", "sign_type", "t" };
        params.put("from", "1");
        params.put("seq", "2");
        params.put("sign", "3");
        params.put("sign_type", "4");
        params.put("t", "5");
        System.out.println(createSign(params));

        System.out.println("2C3NFEWaaedTW1oFYrKL60pl2DCNb43V".equals(Key));
    }
}
