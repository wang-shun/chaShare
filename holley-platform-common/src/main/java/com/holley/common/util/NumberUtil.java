package com.holley.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.holley.common.constants.charge.ChargeWayEnum;

/**
 * 数字操作的功能在org.apache.commons.lang3.math.NumberUtils，这里是补充我们自己的方法
 * 
 * @author zhouli
 */
public class NumberUtil {

    public static int DEF_SCALE = 2;                    // 默认精确的小数位
    public static int PERCISION = BigDecimal.ROUND_DOWN; // 截取

    /**
     * 产生一个任务号
     * 
     * @return
     */
    public static int createTaskId() {
        return Integer.parseInt(StringUtil.randomNumber(4));
    }

    /**
     * 得到百分比，小数点后2位
     * 
     * @param p1
     * @return
     */
    public static String percent(double p1) {
        return percent(p1, 2);
    }

    public static String percent(double p1, int offset) {
        if (Double.isNaN(p1)) {
            p1 = 0.0;
        }
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(offset);
        String res = nf.format(p1);
        res = res.replaceAll(",", "");
        return res;
    }

    /**
     * p1除p2后得到百分比，小数点后2位
     * 
     * @param p1
     * @param p2
     * @return
     */
    public static String percent(double p1, double p2) {
        if (p2 == 0) {
            return "0";
        }
        return percent(p1 / p2);
    }

    /**
     * 根据当前“区域”来格式化数字
     * 
     * @param int newvalue
     * @return String 格式化好的字符串
     */
    public static String formatNumber(long newvalue) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(newvalue);
    }

    /**
     * 以千分位形式显示数字 <br>
     * 如： formatInt(123456) = "123,456"
     * 
     * @param x
     * @return
     */
    public static String formatInt(long x) {
        if (x < 999) {
            return String.valueOf(x);
        }

        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.US);

        return nf.format(x);
    }

    public static String formatDouble2Thousand(Double x, int precision) {
        if (x == null) {
            return null;
        }
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.US);
        nf.setMaximumFractionDigits(precision);
        nf.setMinimumFractionDigits(precision);
        nf.setMinimumIntegerDigits(1);
        return nf.format(x);
    }

    /**
     * 格式化double类型
     * 
     * @param number 需要格式化的数字
     * @param precision 小数点位置
     * @return
     */
    public static String formatDouble(double number, int precision) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(precision);
        format.setMinimumIntegerDigits(1);
        return format.format(number);
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {

        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算百分比
     * 
     * @param inValue 进线数量
     * @param outValue 出线数量
     * @return
     */
    public static String calcRate(Double inValue, Double outValue) {
        if (inValue == null || outValue == null) {
            return "0";
        }
        if (inValue != 0) {
            return String.valueOf((inValue - outValue) * 100 / inValue);
        }
        return "0";
    }

    /**
     * 计算同比、环比
     * 
     * @param thisValue
     * @param preValue
     * @return
     */
    public static String calcRateBl(Double thisValue, Double preValue) {
        if (thisValue == null || preValue == null) {
            return "0";
        }
        if (preValue != 0) {
            return String.valueOf((thisValue - preValue) * 100 / preValue);
        }
        return "0";
    }

    /**
     * 带“%”的百分比
     * 
     * @param inValue
     * @param outValue
     * @param offset
     * @return
     */
    public static String calcRateStr(Double inValue, Double outValue, int offset) {
        // 线损中供电量为0，售电量有的线损率计为-100%
        inValue = inValue == null ? 0 : inValue;
        outValue = outValue == null ? 0 : outValue;

        if (inValue == 0 && outValue != 0) {
            return "-100.00%";
        }
        if (inValue < 0 && outValue == 0) {
            return "0.00%";
        }
        if (inValue != 0 && outValue != null) {
            return NumberUtil.percent((inValue - outValue) / inValue, offset);
        }
        return "0.00%";
    }

    /**
     * 带“%”的百分比
     * 
     * @param inValue 供电量
     * @param outValue 用电量
     * @param outInValue 供出电量
     * @param D1 ,D2 ,D5 计算公式： D1-D2/D1+D5
     * @param offset
     * @return
     */
    public static String calcRateStr(Double inValue, Double outValue, Double outInValue, int offset) {
        // 线损中供电量为0，售电量有的线损率计为-100%
        inValue = inValue == null ? 0 : inValue;
        outValue = outValue == null ? 0 : outValue;
        outInValue = outInValue == null ? 0 : outInValue;

        if (inValue == 0 && outValue != 0) {
            return "-100.00%";
        }
        if (inValue < 0 && outValue == 0) {
            return "0.00%";
        }
        if ((inValue + outInValue) == 0) {
            return "0.00%";
        }
        if (inValue != 0 && outValue != null) {
            return NumberUtil.percent((inValue - outValue) / (inValue + outInValue), offset);
        }
        return "0.00%";
    }

    /**
     * 计算增长比，带“%”的百分比
     * 
     * @param currentValue 本次的数字
     * @param beforeValue 上次次的数字
     * @param offset
     * @return
     */
    public static String calcIncreseStr(Double currentValue, Double beforeValue, int offset) {
        if (currentValue == null || beforeValue == null) {
            return "0";
        }
        if (beforeValue != 0) {
            return NumberUtil.percent((currentValue - beforeValue) / beforeValue, offset);
        }
        return "0";
    }

    /**
     * 数字格式化函数加上百分位
     * 
     * @param number : 格式化前的数字;
     * @param decimalDigits : 小数位数;
     * @return: 三位一组以逗号分割的字符串;
     */
    public static String format(double number, int decimalDigits) {
        if (number == 0d) {
            number = 0d;
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
                return "0" + df.format(number);
            } else {
                return df.format(number);
            }
        } else {
            return df.format(number);
        }
    }

    /**
     * 根据系数确定小数点位数，最多4位
     * 
     * @param factor
     * @return
     */
    public static int getFactorLen(Double factor) {
        if (factor <= 0.0001) {
            return 4;
        } else if (factor <= 0.001) {
            return 3;
        } else if (factor <= 0.01) {
            return 2;
        } else if (factor <= 0.1) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
     * 排序用线损率 如果供电量、售电量都为0 设置线损率为1.01，排在线损率为1的数据之后
     * @param inValue
     * @param outValue
     * @param offset
     * @return
     */

    public static Double calcRateDouble(Double inValue, Double outValue) {
        // 线损中供电量为0，售电量有的线损率计为-1
        inValue = inValue == null ? 0 : inValue;
        outValue = outValue == null ? 0 : outValue;

        if (inValue == 0 && outValue != 0) {
            return -1.00;
        }
        if (inValue < 0 && outValue == 0) {
            return 0.00;
        }
        if (inValue == 0 && outValue == 0) {
            return 1.01;
        }
        if (inValue != 0 && outValue != null) {
            return (inValue - outValue) / inValue;
        }
        return 0.00;
    }

    public static String formatBigDecimal(BigDecimal number, int precision) {
        if (number == null) return "";
        return formatDouble(number.doubleValue(), precision);
    }

    /**
     * w转换为kw
     * 
     * @param power
     * @return
     */
    public static BigDecimal formatToKw(BigDecimal power) {
        return (power != null ? power.divide(BigDecimal.valueOf(1000)).setScale(2, RoundingMode.HALF_UP) : null);
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param b1 减数
     * @param b2 被减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(BigDecimal b1, BigDecimal b2) {
        return b1.subtract(b2).setScale(DEF_SCALE, PERCISION);
    }

    /**
     * 提供精确的乘法运算。
     * 
     * @param b1 乘数
     * @param b2 被乘数
     * @return 两个参数的乘积
     */
    public static BigDecimal mul(BigDecimal b1, BigDecimal b2) {
        return b1.multiply(b2).setScale(DEF_SCALE, PERCISION);
    }

    /**
     * 提供精确的除法运算。
     * 
     * @param b1 除数
     * @param b2 被除数
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal b1, BigDecimal b2) {
        return b1.divide(b2, DEF_SCALE, PERCISION);
    }

    /**
     * 提供精确的加法运算。
     * 
     * @param b1 加数
     * @param b2 被加数
     * @return 两个参数的和
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
        return b1.add(b2).setScale(DEF_SCALE, PERCISION);
    }

    /**
     * 返回保留四舍五入的2位小数
     * 
     * @param b
     * @return
     */
    public static BigDecimal get4Out5In(String b) {
        return new BigDecimal(b).setScale(DEF_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getNotNUll(BigDecimal b) {
        if (b == null) {
            return BigDecimal.ZERO.setScale(NumberUtil.DEF_SCALE);
        } else {
            return b;
        }
    }

    public static BigDecimal formateScale2(BigDecimal value) {
        if (value == null) return null;
        return value.setScale(DEF_SCALE, PERCISION);
    }

    public static BigDecimal formateScale(int scale, BigDecimal value) {
        if (value == null) return null;
        return value.setScale(scale, PERCISION);
    }

    public static String formateScale2Str(BigDecimal value) {
        if (value == null) return "";
        return value.setScale(DEF_SCALE, PERCISION).toString();
    }

    public static String getBinaryStr(String payWay) {
        String[] s1 = payWay.split(",");
        String[] s2 = { ChargeWayEnum.MANUAL.getShortValue().toString(), ChargeWayEnum.CARD.getShortValue().toString(), ChargeWayEnum.APP.getShortValue().toString() };
        List<String> list2 = new ArrayList<String>();
        list2.addAll(Arrays.asList(s2));
        List<String> list1 = new ArrayList<String>();
        list1.addAll(Arrays.asList(s1));
        String str = "00000";
        a: for (String temp1 : list2) {
            for (String temp2 : list1) {
                if (temp1.equals(temp2)) {
                    list1.remove(temp2);
                    str = str + "1";
                    continue a;
                }
            }
            str = str + "0";
        }
        return str;
    }

}
