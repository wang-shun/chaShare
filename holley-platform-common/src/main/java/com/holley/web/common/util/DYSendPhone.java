package com.holley.web.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 第翼短信 短信接口 http://web.1xinxi.cn/
 * 
 * @author shencheng
 */
public class DYSendPhone {

    private static String sign     = "holley";                                    // 签名需要网站配置
    private static String url      = "http://sms.1xinxi.cn/asmx/smsservice.aspx?"; // 短信地址
    private static String username = "13777862839";
    private static String password = "59A4C079B0909901047101A8037F";

    public static void sendPhoneCode(String phone, String content) throws IOException {
        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer(url);

        // 向StringBuffer追加用户名
        sb.append("name=").append(username);

        // 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
        sb.append("&pwd=").append(password);

        // 向StringBuffer追加手机号码
        sb.append("&mobile=").append(phone);

        // 向StringBuffer追加消息内容转URL标准码
        sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));

        // 追加发送时间，可为空，为空为及时发送
        sb.append("&stime=");

        // 加签名
        sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));

        // type为固定值pt extno为扩展码，必须为数字 可为空
        sb.append("&type=pt&extno=");
        // 创建url对象
        // String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
        String addr = sb.toString();
        System.out.println("addr:" + addr);
        connection(addr);
    }

    public static void connection(String addr) throws IOException {
        URL url = new URL(addr);

        // 打开url连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置url请求方式 ‘get’ 或者 ‘post’
        connection.setRequestMethod("POST");

        // 发送
        InputStream is = url.openStream();

        // 转换返回值
        String returnStr = DYSendPhone.convertStreamToString(is);

        // 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
        System.out.println(returnStr);
        // 返回发送结果
    }

    /**
     * 转换返回值类型为UTF-8格式.
     * 
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

    /*
     * public static void main(String[] args) { try { SendPhone.sendPhoneCode("13777862839", "验证码：1234"); } catch
     * (IOException e) { e.printStackTrace(); } }
     */
}
