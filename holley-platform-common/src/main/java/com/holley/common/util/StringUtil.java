package com.holley.common.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringUtil {

    /** 空字符串。 */
    public static final String          EMPTY_STRING        = "";
    public static final String          WEB_SPACE           = "&nbsp;";

    private static final char           QUOTE_ENCODE[]      = "&quot;".toCharArray();
    private static final char           AMP_ENCODE[]        = "&amp;".toCharArray();
    private static final char           LT_ENCODE[]         = "&lt;".toCharArray();
    private static final char           GT_ENCODE[]         = "&gt;".toCharArray();
    private static final int            DUMP_HEX_CHAR_COUNT = 75;
    private static MessageDigest        digest              = null;
    // private static final int fillchar = 61;
    private static Random               randGen             = new Random();
    private static char                 numbersAndLetters[] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char           zeroArray[]         = "0000000000000000".toCharArray();
    private static final char[]         base64Chars         = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final char[]         upcaseHexChar       = "0123456789ABCDEF".toCharArray();
    private static final char[]         lowerHexChar        = "0123456789abcdef".toCharArray();

    private static int[]                hexCharCodes        = new int[256];

    private static int[]                base64Codes         = new int[256];

    // 中文数值转换
    private static Map<Integer, String> cnNumberMap         = new HashMap<Integer, String>();

    static {
        for (int i = 0; i < 256; i++)
            hexCharCodes[i] = base64Codes[i] = -1;
        for (int i = 0; i < base64Chars.length; i++)
            base64Codes[base64Chars[i]] = (byte) i;
        for (int i = 0; i < upcaseHexChar.length; i++)
            hexCharCodes[upcaseHexChar[i]] = (byte) i;
        for (int i = 0; i < lowerHexChar.length; i++)
            hexCharCodes[lowerHexChar[i]] = (byte) i;

        cnNumberMap.put(1, "一");
        cnNumberMap.put(2, "二");
        cnNumberMap.put(3, "三");
        cnNumberMap.put(4, "四");
        cnNumberMap.put(5, "五");
        cnNumberMap.put(6, "六");
        cnNumberMap.put(7, "七");
        cnNumberMap.put(8, "八");
        cnNumberMap.put(9, "九");
        cnNumberMap.put(10, "十");
    }

    /**
     * 如果字符串是<code>null</code>，则返回指定默认字符串，否则返回字符串本身。
     * 
     * <pre>
     * StringUtil.defaultIfNull(null, &quot;default&quot;)  = &quot;default&quot;
     * StringUtil.defaultIfNull(&quot;&quot;, &quot;default&quot;)    = &quot;&quot;
     * StringUtil.defaultIfNull(&quot;  &quot;, &quot;default&quot;)  = &quot;  &quot;
     * StringUtil.defaultIfNull(&quot;bat&quot;, &quot;default&quot;) = &quot;bat&quot;
     * </pre>
     * 
     * @param str 要转换的字符串
     * @param defaultStr 默认字符串
     * @return 字符串本身或指定的默认字符串
     */
    public static String defaultIfNull(String str, String defaultStr) {
        return (str == null) ? defaultStr : str;
    }

    public static boolean isDigits(String str) {
        if ((str == null) || (str.length() == 0)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 替换回车换行符为html的<br>
     * 
     * @param val
     * @return
     */
    public static String replaceBR(String val) {
        return val.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
    }

    /**
     * 使用正则表达式删除HTML标签。
     * 
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 中文数值转换
     * 
     * @param number
     * @return
     */
    public static String converToCNumber(Integer number) {
        return cnNumberMap.get(number);
    }

    public static boolean isDigits(Object obj) {
        if (obj == null) return false;
        String str = obj.toString();
        return isDigits(str);
    }

    public static final String escapeHTMLTags(String in) {
        if (in == null) return null;
        int i = 0;
        int last = 0;
        char input[] = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) ((double) len * 1.3D));
        for (; i < len; i++) {
            char ch = input[i];
            if (ch > '>') continue;
            if (ch == '<') {
                if (i > last) out.append(input, last, i - last);
                last = i + 1;
                out.append(LT_ENCODE);
                continue;
            }
            if (ch != '>') continue;
            if (i > last) out.append(input, last, i - last);
            last = i + 1;
            out.append(GT_ENCODE);
        }

        if (last == 0) return in;
        if (i > last) out.append(input, last, i - last);
        return out.toString();
    }

    public static final synchronized String hash(String data) {
        if (digest == null) try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("Failed to load the MD5 MessageDigest. We will be unable to function normally.");
            nsae.printStackTrace();
        }
        digest.update(data.getBytes());
        return encodeHex(digest.digest());
    }

    public static final String encodeHex(byte bytes[]) {
        char[] buf = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int code = bytes[i] & 0xff;
            buf[2 * i] = upcaseHexChar[code >> 4];
            buf[2 * i + 1] = upcaseHexChar[code & 0xf];
        }
        return new String(buf);
    }

    public static final String dumpHex(byte bytes[]) {
        int bytepos, bufpos, linecount = (bytes.length + 15) / 16;
        char[] buf = new char[linecount * DUMP_HEX_CHAR_COUNT];
        byte[] bs = new byte[16];

        bytepos = 0;
        for (int i = 0; i < linecount; i++) {
            int addr = i * 16;
            bufpos = i * DUMP_HEX_CHAR_COUNT;
            buf[bufpos++] = upcaseHexChar[(addr >> 12) & 0xf];
            buf[bufpos++] = upcaseHexChar[(addr >> 8) & 0xf];
            buf[bufpos++] = upcaseHexChar[(addr >> 4) & 0xf];
            buf[bufpos++] = upcaseHexChar[(addr) & 0xf];
            buf[bufpos++] = ' ';
            buf[bufpos++] = ' ';
            for (int j = 0; j < 16; j++, bytepos++) {
                if (bytepos < bytes.length) {
                    int code = bytes[bytepos] & 0xff;
                    bs[j] = bytes[bytepos];
                    buf[bufpos++] = upcaseHexChar[code >> 4];
                    buf[bufpos++] = upcaseHexChar[code & 0xf];
                    if (j == 7) buf[bufpos++] = '-';
                    else buf[bufpos++] = ' ';
                } else {
                    buf[bufpos++] = ' ';
                    buf[bufpos++] = ' ';
                    buf[bufpos++] = ' ';
                    bs[j] = ' ';
                }
            }
            buf[bufpos++] = ' ';
            buf[bufpos++] = ' ';
            char[] chs = new String(bs).toCharArray();
            for (int k = 0; k < chs.length; k++) {
                char ch = chs[k];
                if ((ch > '\0') && (ch < ' ')) buf[bufpos++] = '.';
                else buf[bufpos++] = ch;

            }
            int endLine = (i + 1) * DUMP_HEX_CHAR_COUNT - 2;
            for (; bufpos < endLine; bufpos++)
                buf[bufpos] = ' ';
            buf[bufpos++] = '\r';
            buf[bufpos++] = '\n';
        }
        return new String(buf);
    }

    public static final byte[] decodeHex(String hex) {
        char chars[] = hex.toCharArray();
        byte bytes[] = new byte[chars.length / 2];
        int byteCount = 0;
        for (int i = 0; i < chars.length; i += 2) {
            byte newByte = 0;
            newByte |= hexCharCodes[chars[i]];
            newByte <<= 4;
            newByte |= hexCharCodes[chars[i + 1]];
            bytes[byteCount] = newByte;
            byteCount++;
        }

        return bytes;
    }

    public static String encodeBase64(String data) {
        return encodeBase64(data.getBytes());
    }

    public static String encodeBase64(byte data[]) {
        int len = data.length;
        StringBuffer ret = new StringBuffer((len / 3 + 1) * 4);
        for (int i = 0; i < len; i++) {
            int c = data[i] >> 2 & 0x3f;
            ret.append(base64Chars[c]);
            c = data[i] << 4 & 0x3f;
            if (++i < len) c |= data[i] >> 4 & 0xf;
            ret.append(base64Chars[c]);
            if (i < len) {
                c = data[i] << 2 & 0x3f;
                if (++i < len) c |= data[i] >> 6 & 3;
                ret.append(base64Chars[c]);
            } else {
                i++;
                ret.append('=');
            }
            if (i < len) {
                c = data[i] & 0x3f;
                ret.append(base64Chars[c]);
            } else {
                ret.append('=');
            }
        }

        return ret.toString();
    }

    public static byte[] decodeBase64(String data) {
        int len = data.length();
        byte[] result = new byte[((len * 3) / 4)];
        int pos = 0;
        for (int i = 0; i < len; i++) {

            int c = base64Codes[data.charAt(i)];
            i++;
            int c1 = base64Codes[data.charAt(i)];
            c = c << 2 | c1 >> 4 & 3;
            result[pos++] = (byte) c;
            if (++i < len) {
                c = data.charAt(i);
                if (61 == c) break;
                c = base64Codes[data.charAt(i)];
                c1 = c1 << 4 & 0xf0 | c >> 2 & 0xf;
                result[pos++] = (byte) c1;
            }
            if (++i >= len) continue;
            c1 = data.charAt(i);
            if (61 == c1) break;
            c1 = base64Codes[data.charAt(i)];
            c = c << 6 & 0xc0 | c1;
            result[pos++] = (byte) c;
        }
        if (result.length != pos) {
            byte[] result2 = new byte[pos];
            System.arraycopy(result, 0, result2, 0, pos);
            result = result2;
        }
        return result;
    }

    /**
     * Unicode转UTF-8的转化
     * 
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') aChar = '\t';
                    else if (aChar == 'r') aChar = '\r';
                    else if (aChar == 'n') aChar = '\n';
                    else if (aChar == 'f') aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    /**
     * java 中JSON数据特殊字符的处理
     * 
     * @param s
     * @return
     */
    public static String string2Json(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static final String[] toLowerCaseWordArray(String text) {
        if (text == null || text.length() == 0) return new String[0];
        List<String> wordList = new ArrayList<String>();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(text);
        int start = 0;
        for (int end = boundary.next(); end != -1; end = boundary.next()) {
            String tmp = text.substring(start, end).trim();
            tmp = tmp.replace("+", "");
            tmp = tmp.replace("/", "");
            tmp = tmp.replace("\\", "");
            tmp = tmp.replace("#", "");
            tmp = tmp.replace("*", "");
            tmp = tmp.replace(")", "");
            tmp = tmp.replace("(", "");
            tmp = tmp.replace("&", "");
            if (tmp.length() > 0) wordList.add(tmp);
            start = end;
        }

        return (String[]) (String[]) wordList.toArray(new String[wordList.size()]);
    }

    public static final String createTempTable() {
        return "temp_" + StringUtil.randomString(10);
    }

    /**
     * 产生指定长度的字符串
     * 
     * @param length
     * @return
     */
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }

        char randBuffer[] = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
            randBuffer[i] = numbersAndLetters[randGen.nextInt(numbersAndLetters.length)];

        return new String(randBuffer);
    }

    public static final String randomNumber(int length) {
        Long value = Math.abs(randGen.nextLong());
        String strValue = value.toString();
        if (strValue.length() > length) {
            strValue = strValue.substring(0, length);
        }

        return strValue;
    }

    public static final String chopAtWord(String string, int length) {
        if (string == null) return string;
        char charArray[] = string.toCharArray();
        int sLength = string.length();
        if (length < sLength) sLength = length;
        for (int i = 0; i < sLength - 1; i++) {
            if (charArray[i] == '\r' && charArray[i + 1] == '\n') return string.substring(0, i + 1);
            if (charArray[i] == '\n') return string.substring(0, i);
        }

        if (charArray[sLength - 1] == '\n') return string.substring(0, sLength - 1);
        if (string.length() < length) return string;
        for (int i = length - 1; i > 0; i--)
            if (charArray[i] == ' ') return string.substring(0, i).trim();

        return string.substring(0, length);
    }

    public static final String escapeForXML(String string) {
        if (string == null) return null;
        int i = 0;
        int last = 0;
        char input[] = string.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) ((double) len * 1.3D));
        for (; i < len; i++) {
            char ch = input[i];
            if (ch > '>') continue;
            if (ch == '<') {
                if (i > last) out.append(input, last, i - last);
                last = i + 1;
                out.append(LT_ENCODE);
                continue;
            }
            if (ch == '&') {
                if (i > last) out.append(input, last, i - last);
                last = i + 1;
                out.append(AMP_ENCODE);
                continue;
            }
            if (ch != '"') continue;
            if (i > last) out.append(input, last, i - last);
            last = i + 1;
            out.append(QUOTE_ENCODE);
        }

        if (last == 0) return string;
        if (i > last) out.append(input, last, i - last);
        return out.toString();
    }

    public static final String unescapeFromXML(String string) {
        string = string.replace("&lt;", "<");
        string = string.replace("&gt;", ">");
        string = string.replace("&quot;", "\"");
        return string.replace("&amp;", "&");
    }

    public static final String zeroPadString(String string, int length) {
        if (string == null || string.length() > length) {
            return string;
        } else {
            StringBuffer buf = new StringBuffer(length);
            buf.append(zeroArray, 0, length - string.length()).append(string);
            return buf.toString();
        }
    }

    public static final String zeroAppendString(String string, int length) {
        if (string == null || string.length() > length) {
            return string;
        } else {
            StringBuffer buf = new StringBuffer(length);
            buf.append(string).append(zeroArray, 0, length - string.length());
            return buf.toString();
        }
    }

    public static final String charPadString(String string, int length, char append) {
        if (string == null || string.length() > length) {
            return string;
        } else {
            char[] charArray = new char[length - string.length()];
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = append;
            }
            StringBuffer buf = new StringBuffer(length);
            buf.append(charArray, 0, charArray.length).append(string);
            return buf.toString();
        }
    }

    public static final String charAppendString(String string, int length, char append) {
        if (string == null || string.length() > length) {
            return string;
        } else {
            char[] charArray = new char[length - string.length()];
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = append;
            }
            StringBuffer buf = new StringBuffer(length);
            buf.append(string).append(charArray, 0, charArray.length);
            return buf.toString();
        }
    }

    public static final String dateToMillis(Date date) {
        return zeroPadString(Long.toString(date.getTime()), 15);
    }

    public static final String collectionToString(Collection<Object> c, String split) {
        StringBuilder ret = new StringBuilder();
        List<Object> a;
        if (c == null) return null;
        if (split == null) return null;
        a = new ArrayList<Object>(c);
        try {
            for (int i = 0; i < a.size(); i++) {
                String t = (String) a.get(i);
                if (i == a.size() - 1) {
                    ret.append(t);
                } else {
                    ret.append(t).append(split);

                }
            }

            return ret.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String encodeUrlString(String str) {
        String strret = null;
        if (str == null) return str;
        try {
            strret = URLEncoder.encode(str, "GBK");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
        return strret;
    }

    public static String decodeUrlString(String str) {
        String strret = null;
        if (str == null) return str;
        try {
            strret = URLDecoder.decode(str, "GBK");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
        return strret;
    }

    public static String join(Object list[], String separator) {
        int listSize = list.length;
        int bufSize = listSize == 0 ? 0 : (list[0].toString().length() + separator.length()) * listSize;
        StringBuffer buf = new StringBuffer(bufSize);
        for (int i = 0; i < listSize; i++) {
            if (i > 0) buf.append(separator);
            buf.append(list[i]);
        }

        return buf.toString();
    }

    public static <T> String join(Iterator<T> iterator, String separator) {
        StringBuffer buf = new StringBuffer();
        do {
            if (!iterator.hasNext()) break;
            buf.append(iterator.next());
            if (iterator.hasNext()) buf.append(separator);
        } while (true);
        return buf.toString();
    }

    public static boolean isEmpty(String param) {
        return param == null || "".equals(param) || "".equals(param.trim()) || "null".equals(param) || "\"null\"".equals(param) || "undefined".equals(param) || "[]".equals(param);
    }

    public static boolean isNotEmpty(String param) {
        return !isEmpty(param);
    }

    public static int getDecimalplace(String factor) {
        int pointPos = factor.indexOf(".");
        int onePos = factor.indexOf("1");
        int precision = onePos - pointPos;
        return precision > 0 ? precision : 0;
    }

    /**
     * 对字符串做定长处理，超过长度，截取，长度不够补在前方补齐
     * 
     * @param str
     * @param len
     * @param appendStr 补齐的字符，
     * @return
     */
    public static String AddjustLength(String str, int len, String appendStr) {
        if (str == null) {
            return null;
        }
        if (str.length() == len) {
            return str;
        } else if (str.length() < len) {
            StringBuffer buf = new StringBuffer(len);
            for (int i = 0; i < len - str.length(); i++) {
                buf.append(appendStr);
            }
            buf.append(str);
            if (buf.length() > len) {
                return buf.substring(buf.length() - len);
            } else {
                return buf.toString();
            }
        } else {
            return str.substring(str.length() - len, str.length());
        }
    }

    /**
     * 比较separator分隔的2个字符串是否相等
     * 
     * @param str1
     * @param str2
     * @param separator 字符串分隔符
     * @return
     */
    public static boolean isEquals(String str1, String str2, String separator) {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {
            return false;
        }
        String[] str1Array = StringUtils.split(str1, separator);
        String[] str2Array = StringUtils.split(str2, separator);

        if (str1Array.length != str2Array.length) {
            return false;
        }

        List<String> refList = new ArrayList<String>();
        for (String refStr : str1Array) {
            refList.add(refStr);
        }

        for (String desStr : str2Array) {
            if (!refList.contains(desStr)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 转换字符串分隔的字符串为Integer数组
     * 
     * @param values
     * @param spare
     * @return
     */
    public static List<Integer> parseIntList(String values, String spare) {
        List<Integer> list = new ArrayList<Integer>();
        String[] valueArray = StringUtils.split(values, spare);
        if (valueArray != null) {
            for (String value : valueArray) {
                if (NumberUtils.isDigits(value)) {
                    list.add(NumberUtils.toInt(value));
                }
            }
        }
        return list;

    }

    public static double parseDouble(String src) {
        if (!isEmpty(src)) {
            return Double.parseDouble(src);
        }
        return 0;
    }

    public static int parseInt(String src) {
        if (!isEmpty(src)) {
            return Integer.parseInt(src);
        }
        return 0;
    }

    public static long parseLong(String src) {
        if (!isEmpty(src)) {
            return Long.parseLong(src);
        }
        return 0;
    }

    public static String format(String number, int decimalDigits) {
        if (!StringUtil.isEmpty(number) && NumberUtils.isNumber(number)) {
            return StringUtil.format(Double.parseDouble(number), decimalDigits);
        } else {
            return number;
        }
    }

    public static String trim(String src) {
        return src == null ? "" : src.trim();
    }

    /**
     * 计算2个数字字符的百分比 (value-value2)*100/value
     * 
     * @param value
     * @param value2
     * @param decimalDigits
     * @return
     */
    public static String percent(String value, String value2, int decimalDigits) {

        if (NumberUtils.isNumber(value) && NumberUtils.isNumber(value2) && Double.valueOf(value) != 0) {
            Double rate = (Double.valueOf(value) - Double.valueOf(value2)) * 100 / Double.valueOf(value);

            return StringUtil.format(rate, decimalDigits);
        }
        return value2;

    }

    /**
     * 计算2个数字字符的百分比 (value-value2)*100/value2
     * 
     * @param value
     * @param value2
     * @param decimalDigits
     * @return
     */
    public static String percentOpposite(String value, String value2, int decimalDigits) {

        if (NumberUtils.isNumber(value) && NumberUtils.isNumber(value2) && Double.valueOf(value2) != 0) {
            Double rate = (Double.valueOf(value) - Double.valueOf(value2)) * 100 / Double.valueOf(value2);

            return StringUtil.format(rate, decimalDigits);
        }
        return "";

    }

    /**
     * 计算2个数字字符的百分比 value*100/value2
     * 
     * @param value
     * @param value2
     * @param decimalDigits
     * @return
     */
    public static String percentDirect(String value, String value2, int decimalDigits) {

        if (NumberUtils.isNumber(value) && NumberUtils.isNumber(value2) && Double.valueOf(value2) != 0) {
            Double rate = Double.valueOf(value) * 100 / Double.valueOf(value2);
            return StringUtil.format(rate, decimalDigits);
        }
        return null;

    }

    /**
     * 数字格式化函数
     * 
     * @param number : 格式化前的数字;
     * @param decimalDigits : 小数位数;
     * @return: 字符串;
     */
    public static String format(double number, int decimalDigits) {
        if (number == 0d) {
            number = 0d;
        }
        if (Double.isNaN(number)) {
            number = 0.0;
        }
        boolean flag = false;
        if (decimalDigits < 0) {
            // 小数位数不能小于0.
            return "";
        }

        String pattern = "##################";
        if (decimalDigits > 0) {
            flag = true;
            pattern += ".";
            for (int i = 0; i < decimalDigits; i++) {
                pattern += "0";
            }
        }

        DecimalFormat df = new DecimalFormat(pattern);
        if (number <= -1d) {
            return df.format(number);
        } else if (number > -1d && number < 0d) {
            return "-0" + df.format(number).substring(1);
        } else if (number >= 0d && number < 1d) {
            if (flag) {
                String temp = df.format(number);
                if (StringUtil.isNotEmpty(temp) && temp.substring(0, 1).equals(".")) {
                    return "0" + df.format(number);
                } else {
                    return temp;
                }
            } else {
                return df.format(number);
            }
        } else {
            return df.format(number);
        }
    }

    public static Integer toInteger(Object object) {
        if (object == null) {
            return 0;
        }
        return Integer.valueOf(object.toString());
    }

    public static Short toShort(Object object) {
        if (object == null) {
            return null;
        }
        return Short.valueOf(object.toString());
    }

    public static String objectToString(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return obj.toString();
        }
    }

    /**
     * 字串逆排
     * 
     * @return
     */
    public static String revert(String src) {
        if (isEmpty(src)) return "";
        StringBuffer result = new StringBuffer();
        for (int i = src.length() - 1; i >= 0; i--) {
            result.append(src.charAt(i));
        }
        return result.toString();
    }

    public static boolean isValidateString(String path) {
        if (StringUtil.isEmpty(path)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 将工期转换成年份 +2000
     */

    public static Short parseEngidToYearAdd(Short engid) {
        Short year = 0;
        if (engid != null) year = Short.parseShort(String.valueOf(engid + 2000));
        return year;
    }

    /**
     * 将工期转换成年份 -2000
     */
    public static Short parseEngidToYearMinas(Short engid) {
        Short year = 0;
        if (engid != null) year = Short.parseShort(String.valueOf(engid - 2000));
        return year;
    }

    /**
     * jsp页面将工期转换成年份
     */
    public static String parseEngidToYearString(String engid) {
        String str = "";
        if (engid != null && !("").equals(engid)) {
            str = (Integer.parseInt(engid) + 2000) + "年";
        }
        return str;
    }

    /**
     * 正则
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String getSubString(String str) {
        String result = "";
        String start = "";
        String end = "";
        if (str != null) {
            if (str.length() > 6) {
                start = str.substring(0, 3);
                end = str.substring(str.length() - 3, str.length());
                result = start + "***" + end;
            } else {
                result = str;
            }
        }
        return result;
    }

    /**
     * 首字母大写
     * 
     * @param s
     * @return
     */
    public static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }

    /**
     * 真实姓名加星显示
     * 
     * @param name
     * @return
     */
    public static String showStarName(String name) {
        String result = "";
        if (name.length() >= 2) {
            result = name.substring(0, 1);
            for (int i = 0; i < (name.length() - 1); i++) {
                result = result + "*";
            }
        } else {
            result = name;
        }
        return result;
    }

    /**
     * 身份证加星显示
     * 
     * @param str
     * @return
     */
    public static String showStarCardNo(String cardNo) {
        String result = "";
        if (cardNo.length() >= 7) {
            result = cardNo.substring(0, 3);
            String temp = cardNo.substring(cardNo.length() - 4, cardNo.length());
            result = result + "***" + temp;
        } else {
            result = cardNo;
        }
        return result;
    }

    public static String showStar(String str) {
        String result = "";
        if (str.length() >= 6) {
            result = str.substring(0, 3);
            String temp = str.substring(str.length() - 3, str.length());
            result = result + "***" + temp;
        } else {
            result = str;
        }
        return result;
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

    /**
     * 不定参数校验数字
     * 
     * @param args
     * @return
     */
    public static boolean isNotNumber(String... args) {
        for (String arg : args) {
            if (!NumberUtils.isNumber(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 不定参数校验数字
     * 
     * @param args
     * @return
     */
    public static boolean isNotDigits(String... args) {
        for (String arg : args) {
            if (!NumberUtils.isDigits(arg)) {
                return true;
            }
        }
        return false;
    }
}
