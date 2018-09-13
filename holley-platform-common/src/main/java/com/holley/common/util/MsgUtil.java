/**
 * 报文相关的一些常用方法
 */
package com.holley.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Armording
 */
public class MsgUtil {

    public static int Unsignd(byte b) {
        return 0xff & b;
    }

    /**
     * @param hex 10进制数字的二进制表示
     * @return 10进制数字的BCD码
     */
    public static byte HexToBCD(byte hex) {
        return (byte) (hex / 10 * 0x10 + hex % 10);
    }

    /**
     * @param bcd 10进制数字的BCD码
     * @return 10进制数字的二进制表示
     */
    public static byte BCDToHex(byte bcd) {
        return (byte) ((bcd & 0x0F) + ((bcd >> 4) & 0x0F) * 10);
    }

    /**
     * 一组BCD码合成 从offset开始，len 个字符,函数内不检查越界错误
     * 
     * @param bcd 数组
     * @param offset 数组起始字符 offset>=0 && offset<bcd.length
     * @param len 转化字节个数,len > 0 &&len <min(5,bcd.length-offset)
     * @param desc 顺序， desc=true时 低字节在前，高字节在后;desc=false 高字节在前，低字节在后
     * @return
     */
    public static int BCDsToInt(byte bcd[], int offset, int len, boolean desc) {
        int res = 0;
        if (desc) {
            for (int i = len - 1; i >= 0; i--) {
                res = res * 100 + BCDToHex(bcd[offset + i]);
            }
        } else {
            for (int i = 0; i < len; i++) {
                res = res * 100 + (bcd[offset + i]);
            }
        }
        return res;
    }

    /**
     * 和校验
     * 
     * @param webMsg 校验源，byte数组
     * @param from 校验开始字节序号
     * @param num 校验字节数
     * @return 返回和，高位清零
     */
    public static byte CheckSum(byte[] data, int from, int num) {
        int sum = 0;
        for (int i = from; i < from + num; i++) {
            sum += Unsignd(data[i]);
        }
        return (byte) (sum & 0xff);
    }

    /**
     * 把 byte 数组以16进制格式输出到字符串里，便于打印,输出格式样子为:<br>
     * 68 01 01 68 E1 F1
     * 
     * @param byteValue
     * @param len
     * @return
     */
    public static String getByteToHexString(byte[] byteValue, int len, String token) {
        if (byteValue == null) return "";
        String res = "";
        int count = len > byteValue.length ? byteValue.length : len;
        for (int i = 0; i < count; i++) {
            String temp = Integer.toHexString(0xFF & byteValue[i]).toUpperCase();
            if (temp.length() == 1) {
                res += "0" + temp + token;
            } else {
                res += temp + token;
            }

        }
        return res;
    }

    public static String getByteToHexStringDesc(byte[] byteValue, int len, String token) {
        if (byteValue == null) return "";
        String res = "";
        int count = Math.min(len, byteValue.length);
        for (int i = count - 1; i >= 0; i--) {
            String temp = Integer.toHexString(0xFF & byteValue[i]).toUpperCase();
            if (temp.length() == 1) {
                res += "0" + temp + token;
            } else {
                res += temp + token;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String dd = Integer.toHexString(10663);
        byte[] dds = StringToHex(dd);
        System.out.print(dd);

    }

    /**
     * String 转化为 byte
     * 
     * @param str,必须为16进制字符 0~9,A~F，其他字符将被用0替代
     * @return
     */
    public static byte[] StringToHex(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return null;
        if (str.length() == 1) {
            str = "0" + str;
        }
        String newStr = str.replaceAll("[^0-9A-Fa-f]", "0");
        if (newStr == null || newStr.length() == 0) return null;
        if (newStr.length() % 2 == 1) {
            newStr = "0" + newStr;
        }
        int len = newStr.length() / 2;

        byte[] res = new byte[len];
        for (int i = 0; i < len; i++) {
            String t = newStr.substring(newStr.length() - 2 * (i + 1), newStr.length() - 2 * i);
            res[i] = (byte) (Integer.parseInt(t, 16) % 0x100);
        }
        return res;
    }

    public static String reverse(String src, int len) {
        if (src.length() % 2 == 1) src = "0" + src;
        src = StringUtil.AddjustLength(src, len, "0");
        int arrLen = len / 2;
        String[] pwdArray = new String[arrLen];

        for (int i = 0; i < len / 2; i++) {
            pwdArray[i] = src.substring(i * 2, (i + 1) * 2);
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < arrLen; i++) {
            buf.append(pwdArray[arrLen - i - 1]);
        }
        return buf.toString();
    }

    /**
     * 6字节BCD码转化为时间字符串 YYYY-MM-DD mm:hh:00
     * 
     * @param data
     * @param from
     * @param len
     * @return
     */
    public static String getStringDateByBCD(byte[] data, int from, int len) {
        if (data == null || data.length < (from + len)) {
            return null;
        }
        String dateStr = null;
        if (len == 5) {
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:00", data[4 + from], data[3 + from], data[2 + from],
                                    data[1 + from], data[from]);
        } else if (len == 6) {
            dateStr = String.format("%02x%02x-%02X-%02X %02X:%02X:00", data[5 + from], data[4 + from], data[3 + from],
                                    data[2 + from], data[1 + from], data[from]);
        }
        return dateStr;
    }

    /**
     * 6字节BCD码转化为时间字符串 YY-MM-DD mm:hh:ss
     * 
     * @param data
     * @param from
     * @param len
     * @return
     */
    public static String getStringDateByYYMMDDmmhhss(byte[] data, int from, int len) {
        if (data == null || data.length < (from + len)) {
            return null;
        }
        String dateStr = null;
        if (len == 5) {
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:00", data[4 + from], data[3 + from], data[2 + from],
                                    data[1 + from], data[from]);
        } else if (len == 6) {
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:%02X", data[5 + from], data[4 + from], data[3 + from],
                                    data[2 + from], data[1 + from], data[from]);
        }
        return dateStr;
    }

    public static Object getBCDDateByDate(Date beginTime) {
        byte[] data = new byte[7];
        Calendar d = Calendar.getInstance();
        d.setTime(beginTime);
        data[0] = HexToBCD((byte) d.get(Calendar.SECOND));
        data[1] = HexToBCD((byte) d.get(Calendar.MINUTE));
        data[2] = HexToBCD((byte) d.get(Calendar.HOUR_OF_DAY));
        data[3] = HexToBCD((byte) d.get(Calendar.DAY_OF_MONTH));
        data[4] = HexToBCD((byte) (d.get(Calendar.MONTH) + 1));
        data[5] = HexToBCD((byte) (d.get(Calendar.YEAR) % 100));
        data[6] = HexToBCD((byte) (d.get(Calendar.YEAR) / 100));
        return data;
    }

    public static String strReverse(String itemChar) {
        if (itemChar == null) {
            return null;
        }
        String temp = "";
        for (int i = itemChar.length() - 1; i >= 1; i = i - 2) {
            temp += String.valueOf(itemChar.charAt(i - 1)) + String.valueOf(itemChar.charAt(i));
        }
        return temp;
    }
}
