package com.holley.charging.share.util;

import java.security.MessageDigest;

public class MD5Util {

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {

        }
        return resultString.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(MD5Encode("appid=wxf6aafe068889931b&body=充电支付&detail=充电支付&mch_id=1357957402&nonce_str=w9Hs8gt3GTcxZrIv&notify_url=http://183.129.224.70:4680/app/pay/wechatCallbackForCharge.htm&out_trade_no=1234567890ABCDEF1606021541000002&spbill_create_ip=172.16.20.111&time_start=20160627163147&total_fee=15000&trade_type=APP&key=Holley51chargeapp201606270000001",
                                     "UTF-8"));
    }

}
