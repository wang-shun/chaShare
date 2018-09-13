package com.holley.common.constants;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.holley.common.util.PropertiesUtil;

public class InitParams {

    private static final String        SYS_PARAMS         = "SysParams";                  // 系统全局参数
    private static final String        THREAD_POOL_PARAMS = "ThreadPoolParams";           // 线程池参数

    private static Map<String, Object> cache              = new HashMap<String, Object>();

    @SuppressWarnings("unchecked")
    public static String getSysParam(String name) throws IOException {
        Map<String, String> paramMap = (Map<String, String>) cache.get(SYS_PARAMS);
        if (paramMap == null) {
            paramMap = new HashMap<String, String>();
            Properties p = new Properties();
            URL url = PropertiesUtil.class.getClassLoader().getResource("");
            String urlStr = URLDecoder.decode(url.toString(), "UTF-8");
            System.out.println("url:" + urlStr);
            int pos = urlStr.indexOf("classes");
            String filepath = "";
            Properties prop = System.getProperties();
            String os = prop.getProperty("os.name");
            System.out.println(os);
            int startPos = 5;
            if (os.startsWith("win") || os.startsWith("Win")) {
                startPos = 6;
            }
            if (pos >= 0) {
                filepath = urlStr.substring(startPos, pos);
            } else {
                filepath = urlStr.substring(startPos);
            }
            filepath += "conf/app.properties";
            System.out.println("filepath:" + filepath);
            p = PropertiesUtil.loadProperties(filepath, PropertiesUtil.BY_PROPERTYRESOURCEBUNDLE);
            Enumeration<?> keys = p.propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                paramMap.put(key, p.getProperty(key));
            }
            cache.put(SYS_PARAMS, paramMap);
        }
        String value = paramMap.get(name);
        return value;
    }

    @SuppressWarnings("unchecked")
    public static String getThreadPoolParam(String name) throws IOException {
        Map<String, String> paramMap = (Map<String, String>) cache.get(THREAD_POOL_PARAMS);
        if (paramMap == null) {
            paramMap = new HashMap<String, String>();
            Properties p = new Properties();
            URL url = PropertiesUtil.class.getClassLoader().getResource("");
            String urlStr = URLDecoder.decode(url.toString(), "UTF-8");
            // int endPos = urlStr.indexOf("classes");
            String filepath = "";
            Properties prop = System.getProperties();
            String os = prop.getProperty("os.name");
            System.out.println(os);
            int startPos = 5;
            if (os.startsWith("win") || os.startsWith("Win")) {
                startPos = 6;
            }
            // if (endPos >= 0) {
            // filepath = urlStr.substring(startPos, endPos);
            // } else {
                filepath = urlStr.substring(startPos);
            // }
            filepath += "threadPoolConfig.properties";
            p = PropertiesUtil.loadProperties(filepath, PropertiesUtil.BY_PROPERTYRESOURCEBUNDLE);

            Enumeration<?> keys = p.propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                paramMap.put(key, p.getProperty(key));
            }
            cache.put(THREAD_POOL_PARAMS, paramMap);
        }
        String value = paramMap.get(name);
        return value;
    }
}
