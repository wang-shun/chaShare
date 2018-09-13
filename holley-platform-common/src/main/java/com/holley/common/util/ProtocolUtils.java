package com.holley.common.util;

import java.util.Calendar;
import java.util.Date;

import com.holley.common.constants.Globals;

public class ProtocolUtils {

    public static int cyclenth(int x, int y) {
        return (x + Globals.MAX_LEN_RECV - y) % Globals.MAX_LEN_RECV;
    }

    public static String printMsg(int from, int to, byte[] sendData) {
        if (sendData == null || sendData.length <= from || sendData.length < to) {
            return "";
        }
        String res = "";
        if (to > from) {
            for (int i = (int) from; i < to; i++) {
                String temp = Integer.toHexString(0xFF & sendData[i]).toUpperCase();
                if (temp.length() == 1) {
                    res += "0" + temp + " ";
                } else {
                    res += temp + " ";
                }
            }
        } else {

            for (int i = (int) from; i < sendData.length + to; i++) {
                String temp = Integer.toHexString(0xFF & sendData[i % sendData.length]).toUpperCase();
                if (temp.length() == 1) {
                    res += "0" + temp + " ";
                } else {
                    res += temp + " ";
                }
            }
        }
        return res;

    }

    public static int cycpos(int sendPtr, int i) {
        sendPtr += i;
        return sendPtr % Globals.MAX_LEN_RECV;
    }

    public static boolean isEqual(byte[] data, int startpos, byte[] eop, int length) {
        for (int i = 0; i < length; i++) {
            if (data[ProtocolUtils.cycpos(startpos, i)] != eop[i]) {
                return false;
            }
        }
        return true;
    }

    public static String DLMSLNFormat(String ln) {
        String temp = ln.replace("-", ",");
        temp = temp.replace(":", ",");
        temp = temp.replace(".", ",");
        temp = temp.replace("{", "");
        temp = temp.replace("}", "");
        return temp;
    }

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
    public static String getByteToHexString(byte[] byteValue, int off, int len, String token) {
        if (byteValue == null) return "";
        String res = "";
        for (int i = off; i < off + len; i++) {
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

    public static String getByteToHexStringDesc(byte[] byteValue, int from, int len, String token) {
        if (byteValue == null) return "";
        String res = "";
        int count = Math.min(len, byteValue.length - from);
        for (int i = count - 1; i >= 0; i--) {
            String temp = Integer.toHexString(0xFF & byteValue[i + from]).toUpperCase();
            if (temp.length() == 1) {
                res += "0" + temp + token;
            } else {
                res += temp + token;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(Integer.decode("0x12"));
        // byte[] dd = StringToHex("0x12");

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

    /**
     * 固定长度的转化，超过取低位，少了高位补0
     * 
     * @param str
     * @param len 转化为byte后的字节数
     * @return
     */
    public static byte[] StringToHex(String str, int len) {
        if (str == null || str.length() == 0) return null;
        if (str.length() > (2 * len)) {
            return StringToHex(str.substring(str.length() - 2 * len));
        } else if (str.length() == (2 * len)) {
            return StringToHex(str);
        } else {
            for (int i = len * 2 - str.length(); i > 0; i--) {
                str = "0" + str;
            }
            return StringToHex(str);
        }

    }

    public static byte[] logicNameCovert(String name) {
        String[] items = ((String) name).split("[.]", -1);
        byte[] byteName = new byte[6];
        if (items.length != 6) {
            return new byte[] { 0, 0, 0, 0, 0, 0 };
        }
        int i = 0;
        for (String it : items) {
            byteName[i++] = (byte) (Short.parseShort(it) & 0xFF);
        }
        return byteName;
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
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:00", data[4 + from], data[3 + from], data[2 + from], data[1 + from], data[from]);
        } else if (len == 6) {
            dateStr = String.format("%02x%02x-%02X-%02X %02X:%02X:00", data[5 + from], data[4 + from], data[3 + from], data[2 + from], data[1 + from], data[from]);
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
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:00", data[4 + from], data[3 + from], data[2 + from], data[1 + from], data[from]);
        } else if (len == 6) {
            dateStr = String.format("20%02x-%02X-%02X %02X:%02X:%02X", data[5 + from], data[4 + from], data[3 + from], data[2 + from], data[1 + from], data[from]);
        }
        return dateStr;
    }

    public static byte[] getBCDDateByDate(Date beginTime) {
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

    public static String dataToString(Object data) {
        if (data == null) {
            return "";
        }
        if (data instanceof byte[]) {
            byte[] bytes = (byte[]) data;

            return ProtocolUtils.getByteToHexString(bytes, 0, bytes.length, " ");
        }
        return String.valueOf(data);
    }

    public static byte[] replaceDirtyByte(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                result[i] = 32;
            } else {
                result[i] = data[i];
            }
        }
        return result;
    }

    public static byte lowByte(short value) {
        return (byte) (value & 0xFF);
    }

    public static byte highByte(short value) {
        return (byte) ((value >> 8) & 0xFF);
    }

    public static short byteToShort(byte high, byte low) {
        short res = (short) (ProtocolUtils.Unsignd(high) * 0x100 + ProtocolUtils.Unsignd(low));
        return res;
    }

    public static int byteToInteger(byte[] data, int from) {
        if (data == null || data.length < 4 + from) {
            return 0;
        }
        return (int) (ProtocolUtils.Unsignd(data[from + 3]) * 0x1000000 + ProtocolUtils.Unsignd(data[from + 2]) * 0x10000 + ProtocolUtils.Unsignd(data[from + 1]) * 0x100 + ProtocolUtils.Unsignd(data[from]));
    }

    public static void copyBytes(byte[] buf, int from1, byte[] resbuf, int from2, int len) {
        if (buf == null || resbuf == null) {
            return;
        }
        for (int i = 0; i < len; i++) {
            if (i + from1 >= buf.length || i + from2 >= resbuf.length) {
                return;
            }
            resbuf[i + from2] = buf[i + from1];
        }

    }

    public static void copyBytes(byte[] buf, byte[] resbuf, int len) {
        if (buf == null || resbuf == null) {
            return;
        }
        copyBytes(buf, 0, resbuf, 0, len);
    }

    public static String hex2Bin(byte src) {
        String result = new String();
        for (int i = 0; i < 8; i++) {
            if ((src & 0x01) == 1) {
                result = "1" + result;
            } else {
                result = "0" + result;
            }
            src >>= 1;
        }
        return result.toString();
    }

    public static float byte2int_Float(byte b[], int index) {
        int bits = b[index + 3] & 0xff | (b[index + 2] & 0xff) << 8 | (b[index + 1] & 0xff) << 16 | (b[index] & 0xff) << 24;

        int sign = ((bits & 0x80000000) == 0) ? 1 : -1;
        int exponent = ((bits & 0x7f800000) >> 23);
        int mantissa = (bits & 0x007fffff);

        mantissa |= 0x00800000;
        // Calculate the result:
        float f = (float) (sign * mantissa * Math.pow(2, exponent - 150));
        return f;
    }

    public static Date adjustTimeBySampleInterval(Calendar now, String sampleinterval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now.getTime());
        if (sampleinterval == null) {
            return cal.getTime();
        }
        String type = sampleinterval.substring(0, 2);
        int num = 0;
        try {
            num = Integer.parseInt(sampleinterval.substring(2));
        } catch (Exception e) {
            return cal.getTime();
        }
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);

        if ("MI".equalsIgnoreCase(type)) {
            num %= 60;
            cal.set(Calendar.MINUTE, now.get(Calendar.MINUTE) / num * num);
        } else if ("HH".equalsIgnoreCase(type)) {
            num %= 24;
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR, now.get(Calendar.HOUR) / num * num);
        } else if ("DD".equalsIgnoreCase(type)) {
            num %= 31;
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) / num * num + 1);
        } else if ("MM".equalsIgnoreCase(type)) {
            num %= 12;
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.MONTH, now.get(Calendar.MONTH) / num * num);
        }

        return cal.getTime();
    }

    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

}
