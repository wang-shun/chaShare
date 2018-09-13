package com.holley.web.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 百度凯信通短信 短信接口
 * 
 * @author shencheng
 */
public class BaiduSendPhone {

    private static String httpUrl = "http://apis.baidu.com/kingtto_media/106sms/106sms";
    private static String apikey  = "38859d56be0795e962c00bfea451da2c";

    /*
     * public static void main(String[] args) { sendPhoneCode("13777862839", "【holly】验证码：1234"); }
     */

    /**
     * @param urlAll :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */
    public static boolean sendPhoneCode(String phone, String content) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String requrl = httpUrl + "?" + "tag=2" + "&mobile=" + phone + "&content=" + content;

        try {
            URL url = new URL(requrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", apikey);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }

            result = sbf.toString();
            System.out.println(result);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
