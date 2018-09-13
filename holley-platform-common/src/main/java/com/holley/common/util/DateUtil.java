package com.holley.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.holley.common.constants.CircleTypeEnum;

public class DateUtil extends DateUtils {

    /* 带分秒的时间格式化 */
    public static String TIME_LONG       = "yyyy-MM-dd HH:mm:ss";
    public static String TIME_LONG_CN    = "yyyy年MM月dd日 HH:mm:ss";
    public static String TIME_LONG_14    = "yyyyMMddHHmmss";

    /* 不带秒的时间格式 */
    public static String TIME_NO_SEC     = "yyyy-MM-dd HH:mm";
    public static String TIME_NO_SEC_10  = "yyMMddHHmm";

    /* 只有日期的时间格式化 */
    public static String TIME_SHORT      = "yyyy-MM-dd";
    public static String TIME_SHORT_CN   = "yyyy年MM月dd日";

    public static String DATE_AND_MONTH  = "yyyy-MM-dd HH";

    /* 只有日期的年月格式化 */
    public static String YEAR_MONTH      = "yyMM";

    /* 只有日期的年格式化 */
    public static String YEAR            = "yy";

    public static String YEAR_LONG       = "yyyy";

    /* 只有日期的小时格式化 */
    public static String HOUR            = "HH";

    /* 只格式化小时分钟 */
    public static String HOUR_MIN        = "HH:mm";

    public static String DAY_HOUR_MIN_CN = "dd日HH:mm";

    /* 只格式化日期的天 */
    public static String DAY             = "dd";

    public static String MONTH           = "MM";

    public static String YEARMONTH       = "yyyyMM";

    public static String MONTHTIME       = "yyyy-MM";

    public static String MONTHTIME_CN    = "yyyy年MM月";
    public static int    PRE_ONE_MONTH   = -1;                    // 上1个月
    public static int    PRE_THREE_MONTH = -3;                    // 上3个月

    /**
     * 得到每月的最大日期数字
     * 
     * @param date
     * @return
     */
    public static int getMaxMonthDay(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        cr.set(Calendar.DAY_OF_MONTH, 1);
        cr.roll(Calendar.DAY_OF_MONTH, -1);
        return cr.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到两个月中的最大日期数字
     * 
     * @param date
     * @return
     */
    public static int getMaxMonthDay(Date date1, Date date2) {
        int maxDay1 = getMaxMonthDay(date1);
        int maxDay2 = getMaxMonthDay(date2);
        int maxDay;
        if (maxDay1 > maxDay2) {
            maxDay = maxDay1;
        } else {
            maxDay = maxDay2;
        }
        return maxDay;
    }

    /**
     * 日期按照HH:mm格式转化字符串
     * 
     * @param date
     * @return
     */
    public static String DateToHHMMStr(Date date) {
        return DateToStr(date, HOUR_MIN);
    }

    /**
     * 判断方案类型，转换年，月的表名
     * 
     * @param date
     * @param schemeId
     * @return
     */
    public static String getDateStrBySchemeId(Date date, Short schemeId) {
        if (CircleTypeEnum.MONTH.getShortValue().equals(schemeId)) {
            return DateUtil.DateToStr(date, DateUtil.YEAR);
        } else {
            return DateUtil.DateToStr(date, DateUtil.YEAR_MONTH);
        }
    }

    /**
     * 日期按照HH格式转化字符串
     * 
     * @param date
     * @return
     */
    public static String DateToHHStr(Date date) {
        return DateToStr(date, HOUR);
    }

    /**
     * 日期按照dd格式转化字符串
     * 
     * @param date
     * @return
     */
    public static String DateToDayStr(Date date) {
        return DateToStr(date, DAY);
    }

    /**
     * 日期按照yy格式转换字符串
     * 
     * @param date
     * @return
     */
    public static String DateToYYStr(Date date) {
        return DateToStr(date, YEAR);
    }

    /**
     * 日期按照yyyy格式转换字符串
     * 
     * @param date
     * @return
     */
    public static String DateToYYYYStr(Date date) {
        return DateToStr(date, YEAR_LONG);
    }

    /**
     * 日期按照yyMM格式转换字符串
     * 
     * @param date
     * @return
     */
    public static String DateToYYMMStr(Date date) {
        return DateToStr(date, YEAR_MONTH);
    }

    public static String DateToYYYYMMStr(Date date) {
        return DateToStr(date, MONTHTIME);
    }

    public static String DateToYYYYMMStr2(Date date) {
        return DateToStr(date, MONTHTIME_CN);
    }

    /**
     * 日期按照yyyy-MM-dd HH:mm:ss格式格式转换字符串
     * 
     * @param date
     * @param Format
     * @return
     */
    public static String DateToLongStr(Date date) {
        return DateToStr(date, TIME_LONG);
    }

    /**
     * 日期按照yyyyMMddHHmmss格式格式转换字符串
     * 
     * @param date
     * @return
     */
    public static String DateToLong14Str(Date date) {
        return DateToStr(date, TIME_LONG_14);
    }

    /**
     * 日期按照yyyy-MM-dd格式格式转换字符串
     * 
     * @param date
     * @return
     */
    public static String DateToShortStr(Date date) {
        return DateToStr(date, TIME_SHORT);
    }

    /**
     * 按照指定格式格式转换字符串
     * 
     * @param date
     * @param Format
     * @return
     */
    public static String DateToStr(Date date, String Format) {
        if (date == null) return "";
        SimpleDateFormat formater = new java.text.SimpleDateFormat(Format);
        return formater.format(date);
    }

    /**
     * 日期按照yyyy-MM-dd HH:mm格式转化字符串
     * 
     * @param date
     * @return
     */
    public static String DateToNosecStr(Date date) {
        return DateToStr(date, TIME_NO_SEC);
    }

    public static String DateToNosec10Str(Date date) {
        return DateToStr(date, TIME_NO_SEC_10);
    }

    /**
     * 指定的格式yyyy-MM-dd HH:mm:ss的字符串按照转换为日期
     * 
     * @param dateStr
     * @param Format
     * @return
     */
    public static Date LongStrToDate(String dateStr) {
        if (dateStr.length() > 16) {
            return StrToDate(dateStr, TIME_LONG);
        } else if (dateStr.length() > 13) {
            return StrToDate(dateStr, TIME_NO_SEC);
        } else if (dateStr.length() > 9) {
            return StrToDate(dateStr, TIME_SHORT);
        } else if (dateStr.length() > 6) {
            return StrToDate(dateStr, MONTHTIME);
        } else if (dateStr.length() > 3) {
            return StrToDate(dateStr, "yyyy");
        } else {
            return null;
        }
    }

    /**
     * 指定的格式yyyy-MM-dd的字符串按照转换为日期
     * 
     * @param dateStr
     * @param Format
     * @return
     */
    public static Date ShortStrToDate(String dateStr) {
        return StrToDate(dateStr, TIME_SHORT);
    }

    /**
     * 指定的格式yyyy-MM-dd HH:mm的字符串按照转换为日期
     * 
     * @param dateStr
     * @return
     */
    public static Date NosecStrToDate(String dateStr) {
        return StrToDate(dateStr, TIME_NO_SEC);
    }

    /**
     * 指定的格式的字符串按照转换为日期
     * 
     * @param dateStr
     * @param Format
     * @return
     */
    public static Date StrToDate(String dateStr, String Format) {
        SimpleDateFormat formater = new java.text.SimpleDateFormat(Format);
        try {
            return formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到当前时间的开始的第一年
     * 
     * @param date
     * @return
     */
    public static Date getFirstYear(Date date) {
        if (date != null) {
            Calendar cr = Calendar.getInstance();
            cr.setTime(date);
            cr.set(Calendar.MONDAY, 0);
            cr.set(Calendar.DAY_OF_MONTH, 1);
            cr.set(Calendar.HOUR_OF_DAY, 0);
            cr.set(Calendar.MINUTE, 0);
            cr.set(Calendar.SECOND, 0);
            cr.set(Calendar.MILLISECOND, 0);
            return cr.getTime();
        }

        return date;
    }

    /**
     * 获取后count年的date
     * 
     * @param date
     * @param count
     * @return
     */
    public static Date getADDYear(Date date, int count) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        cr.add(Calendar.YEAR, count);
        return cr.getTime();
    }

    /**
     * 计算两个任意时间中间的间隔天数
     * 
     * @param startday
     * @param endday
     * @return
     */
    public static int getIntervalDays(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    public static int getIntervalHours(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60 * 60));
    }

    public static int getIntervalMinutes(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60));
    }

    public static int getIntervalSecond(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / 1000);
    }

    /**
     * 得到date的 小时数字
     * 
     * @param date
     * @return
     */
    public static int getHourValue(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        return cr.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinuteValue(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        return cr.get(Calendar.MINUTE);
    }

    /**
     * 得到date的日数字
     * 
     * @param date
     * @return
     */
    public static int getDayValue(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        return cr.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到date的月数字
     * 
     * @param date
     * @return
     */
    public static int getMonthValue(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        return cr.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到date的年数字
     * 
     * @param date
     * @return
     */
    public static int getYearValue(Date date) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(date);
        return cr.get(Calendar.YEAR);
    }

    /**
     * 得到每个月的第一天
     * 
     * @param date 传入的需要比较的时间
     * @return
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.set(Calendar.HOUR, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        a.set(Calendar.MILLISECOND, 0);
        return a.getTime();
    }

    /**
     * 得到每个月的最后一天
     * 
     * @param date 传入的需要比较的时间
     * @return
     */
    public static Date getMonthLastDay(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        a.set(Calendar.DATE, 1); // 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        a.set(Calendar.HOUR, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        a.set(Calendar.MILLISECOND, 0);
        return a.getTime();
    }

    public static int getMondayPlus(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    public static Boolean isWorkDay(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 得到某个时间的星期1的日期
     * 
     * @param date
     * @return
     */
    public static Date getMonday(Date date) {
        int mondayPlus = DateUtil.getMondayPlus(date);
        Date value = DateUtils.addDays(date, mondayPlus);
        return value;
    }

    /**
     * 得到某个时间的星期7的日期
     * 
     * @param date
     * @return
     */
    public static Date getSunday(Date date) {
        Date value = DateUtil.getMonday(date);
        return DateUtils.addDays(value, 6);
    }

    /**
     * 得到季度开始时间
     * 
     * @param date
     * @return
     */
    public static Date getQuarter(Date date) {
        int month = DateUtil.getMonthValue(date);
        Date firstYear = DateUtil.getFirstYear(date);
        if (month < 4) {
            return firstYear;
        } else if (month < 7) {
            return DateUtils.addMonths(firstYear, 3);
        } else if (month < 10) {
            return DateUtils.addMonths(firstYear, 6);
        } else {
            return DateUtils.addMonths(firstYear, 9);
        }
    }

    /**
     * 得到季度结束时间
     * 
     * @param date
     * @return
     */
    public static Date getEndQuarter(Date date) {
        int month = DateUtil.getMonthValue(date);
        Date firstYear = DateUtil.getFirstYear(date);
        if (month < 4) {
            return DateUtils.addMonths(firstYear, 2);
        } else if (month < 7) {
            return DateUtils.addMonths(firstYear, 5);
        } else if (month < 10) {
            return DateUtils.addMonths(firstYear, 8);
        } else {
            return DateUtils.addMonths(firstYear, 11);
        }
    }

    /**
     * 得到当前季度季度
     * 
     * @param date
     * @return 1,2,3,4
     */
    public static int getQuarterNumber(Date date) {
        int month = DateUtil.getMonthValue(date);
        if (month < 4) {
            return 1;
        } else if (month < 7) {
            return 2;
        } else if (month < 10) {
            return 3;
        } else {
            return 4;
        }
    }

    public static Date getLastWorkDay(Date date) {
        Date value = DateUtil.addDays(date, -1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
            return getLastWorkDay(value);
        }
        return value;
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.DATE, 0);
        return calendar.getTime();
    }

    public static Date getLastMonthDayHourOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 11);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    // 月25日
    public static Date get25Day(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getFirstHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getPreHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, getHourValue(date) - 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getSomeHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getSomeMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getSomeMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, month + getMonthValue(date) - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, getHourValue(date));
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastDayOfMonth(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();

    }

    public static Date getSomeDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, days + getDayValue(date));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastMonthOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 11);
        return calendar.getTime();
    }

    public static Date getFirstMonthOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);

        return calendar.getTime();
    }

    public static Date getPreMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 计算日或者月时段,计算2个日期间的时段，用formatStr格式化,把结果放入list 不改变外面传入的formatStr格式化
     * 
     * @param beginDate
     * @param endDate
     * @param formatStr
     * @param calenderConstants Calendar.DAY_OF_MONTH等对应的整形
     * @return
     */
    public static List<String> getDateBetweenEx(Date beginDate, Date endDate, String formatStr, int calenderConstants) {
        DateFormat f = new SimpleDateFormat(formatStr);

        String beginDateStr = DateUtil.DateToStr(beginDate, formatStr);
        String endDateStr = DateUtil.DateToStr(endDate, formatStr);

        Date date1 = DateUtil.StrToDate(beginDateStr, formatStr);
        Date date2 = DateUtil.StrToDate(endDateStr, formatStr);

        List<String> list = new ArrayList<String>();
        if (date1 == null) {
            return list;
        }

        list.add(f.format(date1));

        if (endDate == null || beginDate.after(endDate)) {
            return list;
        }

        while (date1.compareTo(date2) < 0) {
            if (calenderConstants == Calendar.DAY_OF_MONTH) {
                date1 = DateUtils.addDays(date1, 1);
            } else if (calenderConstants == Calendar.MONTH) {
                date1 = DateUtils.addMonths(date1, 1);
            } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
                date1 = DateUtils.addHours(date1, 1);
            } else {
                return list;
            }
            String date1Str = f.format(date1);
            if (!list.contains(date1Str)) { // 避免重复数据
                list.add(date1Str);
            }
        }
        return list;
    }

    public static List<String> getSecondForDay(Date date, int maxH) {
        if (maxH > 24) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int size = maxH * 60 * 60;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, i);
            list.add(DateToLongStr(c.getTime()));
            System.out.println(DateToLongStr(c.getTime()));
        }
        return list;
    }

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(DateToLongStr(calendar.getTime()));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println(DateToLongStr(calendar.getTime()));
        // long start = System.currentTimeMillis();
        // List<String> l = getSecondForDay(new Date(), 24);
        // long end = System.currentTimeMillis();
        // System.out.println(end - start);
        // System.out.println(l.size());
        // System.out.println(DateToLongStr(c.getTime()));
        // Date date = DateUtil.StrToDate("20140901 0005", "yyyyMMdd HHmm");
        // System.out.print(DateUtil.DateToLongStr(getCyc5Minute(new Date())));
        /*
         * Calendar calendar = Calendar.getInstance(); calendar.roll(Calendar.MONTH, -1); SimpleDateFormat formater =
         * new SimpleDateFormat("yyyyMM"); System.out.println(formater.format(calendar.getTime()));
         * System.out.println(calendar.get(Calendar.YEAR)); System.out.println(calendar.get(Calendar.MONTH) + 1); Date s
         * = new Date(); Date e = DateUtil.addSeconds(s, 3); System.out.println(getIntervalSecond(s, e));
         * System.out.println(DateToStr(new Date(), TIME_LONG_CN));
         */
        // System.out.println(DateToShortStr(getADDYear(new Date(), 3)));
    }

    /**
     * 计算日或者月时段,计算2个日期间的时段，用formatStr格式化,把结果放入list
     * 
     * @param beginDate
     * @param endDate
     * @param formatStr
     * @param calenderConstants Calendar.DAY_OF_MONTH等对应的整形
     * @return
     */
    public static List<String> getDateBetween(Date beginDate, Date endDate, String formatStr, int calenderConstants) {
        DateFormat f = new SimpleDateFormat(formatStr);

        if (calenderConstants == Calendar.DAY_OF_MONTH) {
            formatStr = DateUtil.TIME_SHORT;
        } else if (calenderConstants == Calendar.MONTH) {
            formatStr = DateUtil.YEARMONTH;
        } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
            formatStr = DateUtil.DATE_AND_MONTH;
        } else if (calenderConstants == Calendar.MINUTE) {
            formatStr = DateUtil.TIME_NO_SEC;
        } else if (calenderConstants == Calendar.YEAR) {
            formatStr = DateUtil.YEAR_LONG;
        }
        String beginDateStr = DateUtil.DateToStr(beginDate, formatStr);
        String endDateStr = DateUtil.DateToStr(endDate, formatStr);

        Date date1 = DateUtil.StrToDate(beginDateStr, formatStr);
        Date date2 = DateUtil.StrToDate(endDateStr, formatStr);

        List<String> list = new ArrayList<String>();
        if (date1 == null) {
            return list;
        }

        list.add(f.format(date1));

        if (endDate == null || beginDate.after(endDate)) {
            return list;
        }

        while (date1.compareTo(date2) < 0) {
            if (calenderConstants == Calendar.DAY_OF_MONTH) {
                date1 = DateUtils.addDays(date1, 1);
            } else if (calenderConstants == Calendar.MONTH) {
                date1 = DateUtils.addMonths(date1, 1);
            } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
                date1 = DateUtils.addHours(date1, 1);
            } else if (calenderConstants == Calendar.MINUTE) {
                date1 = DateUtils.addMinutes(date1, 15);
            } else if (calenderConstants == Calendar.YEAR) {
                date1 = DateUtils.addYears(date1, 1);
            } else {
                return list;
            }
            String date1Str = f.format(date1);
            if (!list.contains(date1Str)) { // 避免重复数据
                list.add(date1Str);
            }
        }
        return list;
    }

    /**
     * 月末20点，日20点
     * 
     * @param beginDate
     * @param endDate
     * @param formatStr
     * @param calenderConstants
     * @return
     */
    public static List<String> getDateBetweenLast20Hour(Date beginDate, Date endDate, String formatStr, int calenderConstants) {
        DateFormat f = new SimpleDateFormat(formatStr);

        formatStr = DateUtil.TIME_LONG;
        String beginDateStr = DateUtil.DateToStr(beginDate, formatStr);
        String endDateStr = DateUtil.DateToStr(endDate, formatStr);

        Date date1 = DateUtil.StrToDate(beginDateStr, formatStr);
        Date date2 = DateUtil.StrToDate(endDateStr, formatStr);

        List<String> list = new ArrayList<String>();
        if (date1 == null) {
            return list;
        }
        if (calenderConstants == Calendar.DAY_OF_MONTH) {
            list.add(f.format(getLastDayOfMonth(date1, 20)));
        } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
            list.add(f.format(getSomeHour(date1, 20)));
        }

        if (endDate == null || beginDate.after(endDate)) {
            return list;
        }

        while (date1.compareTo(date2) < 0) {
            if (calenderConstants == Calendar.DAY_OF_MONTH) {
                date1 = getLastDayOfMonth(DateUtils.addMonths(date1, 1), 20);// 月末20
            } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
                date1 = getSomeHour(DateUtils.addDays(date1, 1), 20);// 日20点数据
            } else {
                return list;
            }
            String date1Str = f.format(date1);
            if (!list.contains(date1Str)) { // 避免重复数据
                list.add(date1Str);
            }
        }
        return list;
    }

    /**
     * 计算月份时段,计算2个日期间的时段，用formatStr格式化,把结果放入list
     * 
     * @param beginDate
     * @param endDate
     * @param formatStr
     * @return
     */
    public static List<String> getMonthBetween(Date beginDate, Date endDate, String formatStr) {
        return getDateBetween(beginDate, endDate, formatStr, Calendar.MONTH);
    }

    /**
     * 计算年份时段,计算2个日期间的时段，用formatStr格式化,把结果放入list
     * 
     * @param beginDate
     * @param endDate
     * @param formatStr
     * @return
     */
    public static List<String> getYearBetween(Date beginDate, Date endDate, String formatStr) {
        DateFormat f = new SimpleDateFormat(formatStr);

        String beginDateStr = DateUtil.DateToStr(beginDate, formatStr);
        String endDateStr = DateUtil.DateToStr(endDate, formatStr);

        Date date1 = DateUtil.StrToDate(beginDateStr, formatStr);
        Date date2 = DateUtil.StrToDate(endDateStr, formatStr);

        List<String> list = new ArrayList<String>();
        list.add(beginDateStr);

        if (endDate == null || beginDate.after(endDate)) {
            return list;
        }

        while (date1.compareTo(date2) < 0) {
            date1 = DateUtils.addYears(date1, 1);
            list.add(f.format(date1));
        }
        return list;
    }

    // 将这种格式的"Thu May 10 14:13:02 CST 2012"date 转为 yyyy-MM-dd HH:mm:ss 这种格式
    public static String DateStrTimeToLongStr(String dateStr) {
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
        Date date = null;
        try {
            // 把字符串转换成CST日期类型
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 把CST格式转换成普通日期格式
        return sdf.format(date);
    }

    //

    /**
     * 日期转换成字符串
     * 
     * @param aDate 日期
     * @param dateSpan 时间分割0 为没分割
     * @param dateTimeSpan 日期和时间的分割字符 0 没分割符
     * @param timeSpan 时间的分割字符
     * @return Description of the Returned Value
     */
    public static String DateTimeToStr(Date aDate, char dateSpan, char dateTimeSpan, char timeSpan) {
        if (aDate == null) {
            return null;
        }
        StringBuffer dataBuf = new StringBuffer(20);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(aDate);
        dataBuf.append(calendar.get(Calendar.YEAR));
        if (dateSpan != 0) {
            dataBuf.append(dateSpan);
        }
        int month = calendar.get(Calendar.MONTH) + 1;
        appendInt(dataBuf, month);
        if (dateSpan != 0) {
            dataBuf.append(dateSpan);
        }
        int date = calendar.get(Calendar.DATE);
        appendInt(dataBuf, date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if (hour + min + second > 0) {
            if (dateTimeSpan != 0) dataBuf.append(dateTimeSpan);
            appendInt(dataBuf, hour);
            if (timeSpan != 0) {
                dataBuf.append(timeSpan);
            }
            appendInt(dataBuf, min);
            if (timeSpan != 0) {
                dataBuf.append(timeSpan);
            }
            appendInt(dataBuf, second);
        }
        return dataBuf.toString();
    }

    public static Date getDate(int year, int month, int day, int hour, int min, int sec) {
        Calendar cl = Calendar.getInstance();
        cl.set(year, month, day, hour, min, sec);
        return cl.getTime();
    }

    private static void appendInt(StringBuffer buf, int nDate) {
        if (nDate < 10) {
            buf.append("0");
        }
        buf.append(nDate);
    }

    /**
     * 计算两个日期间的分钟数，截止日期必须大于起始日期
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static long calcMinuteBetween2Dates(Date startDate, Date endDate) {
        if (startDate.compareTo(endDate) > 0) {
            return 0;
        }
        long start = startDate.getTime();
        long end = endDate.getTime();
        return (end - start) / (1000 * 60);
    }

    public static Date getCircleEndTimeOther(Date startTime, int circleTypeId, int offset) {
        CircleTypeEnum currCircleType = CircleTypeEnum.getEnmuByValue(circleTypeId);
        if (currCircleType == null || startTime == null) {
            return null;
        }

        if (currCircleType == CircleTypeEnum.HOUR) {
            return DateUtils.addHours(startTime, offset);
        } else if (currCircleType == CircleTypeEnum.DAY) {
            return DateUtils.addDays(startTime, offset);
        } else if (currCircleType == CircleTypeEnum.MONTH) {
            return DateUtils.addMonths(startTime, offset);
        } else if (currCircleType == CircleTypeEnum.QUARTER) {// 20140305新增
            return DateUtils.addMonths(startTime, offset);
        }

        return startTime;
    }

    /**
     * 根据周期类型转换date为指定的格式： yymm 或者 yy,作为分表的表名后缀
     * 
     * @param date
     * @param circleType
     * @return
     */
    public static String getTableNameByCircleType(Date date, int circleType) {
        if (circleType == CircleTypeEnum.DAY.getValue()) {
            return DateUtil.DateToYYMMStr(date);
        } else if (circleType == CircleTypeEnum.MONTH.getValue()) {
            return DateUtil.DateToYYStr(date);
        }
        return DateUtil.DateToYYMMStr(date);
    }

    /**
     * 每15分钟
     * 
     * @param date
     * @return
     */
    public static Date getCyc15Minute(Date date) {
        Date curr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, getHourValue(curr));
        int minute = getMinuteValue(curr) / 15 * 15;
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 每5分钟 ,当前时间设置为最靠近的上一个5分钟间隔的时刻
     * 
     * @param date
     * @return
     */
    public static Date getCyc5Minute(Date date) {
        Date curr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, getHourValue(curr));
        int minute = getMinuteValue(curr) / 5 * 5;
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static List<String> getLossDateBetween(Date beginDate, Date endDate, String formatStr, int calenderConstants, int collectcyc) {
        DateFormat f = new SimpleDateFormat(formatStr);

        // if (calenderConstants == Calendar.DAY_OF_MONTH) {
        // formatStr = DateUtil.TIME_SHORT;
        // } else if (calenderConstants == Calendar.MONTH) {
        // formatStr = DateUtil.YEARMONTH;
        // } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
        // formatStr = DateUtil.DATE_AND_MONTH;
        // }
        String beginDateStr = DateUtil.DateToStr(beginDate, formatStr);
        String endDateStr = DateUtil.DateToStr(endDate, formatStr);

        Date date1 = DateUtil.StrToDate(beginDateStr, formatStr);
        Date date2 = DateUtil.StrToDate(endDateStr, formatStr);

        List<String> list = new ArrayList<String>();
        if (date1 == null) {
            return list;
        }

        list.add(f.format(date1));

        if (endDate == null || beginDate.after(endDate)) {
            return list;
        }

        while (date1.compareTo(date2) < 0) {
            if (calenderConstants == Calendar.DAY_OF_MONTH) {
                date1 = DateUtils.addDays(date1, collectcyc);
            } else if (calenderConstants == Calendar.MONTH) {
                date1 = DateUtils.addMonths(date1, collectcyc);
            } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
                date1 = DateUtils.addHours(date1, collectcyc);
            } else if (calenderConstants == Calendar.MINUTE) {
                date1 = DateUtils.addMinutes(date1, collectcyc);
            } else {
                return list;
            }
            String date1Str = f.format(date1);
            if (!list.contains(date1Str)) { // 避免重复数据
                list.add(date1Str);
            }
        }
        return list;
    }

    public static List<Date> getDateBetween(Date date1, Date date2, int calenderConstants, int collectcyc) {
        List<Date> list = new ArrayList<Date>();
        if (date1 == null) {
            return list;
        }
        list.add(date1);
        if (date2 == null || date1.after(date2)) {
            return list;
        }
        while (date1.compareTo(date2) < 0) {
            if (calenderConstants == Calendar.DAY_OF_MONTH) {
                date1 = DateUtils.addDays(date1, collectcyc);
            } else if (calenderConstants == Calendar.MONTH) {
                date1 = DateUtils.addMonths(date1, collectcyc);
            } else if (calenderConstants == Calendar.HOUR_OF_DAY) {
                date1 = DateUtils.addHours(date1, collectcyc);
            } else if (calenderConstants == Calendar.MINUTE) {
                date1 = DateUtils.addMinutes(date1, collectcyc);
            } else {
                return list;
            }
            if (!list.contains(date1)) { // 避免重复数据
                list.add(date1);
            }
        }
        return list;
    }

    public static List<Date> getLoadDateBetween(Date date1, Date date2, int points) {
        List<Date> list = new ArrayList<Date>();
        if (date1 == null) {
            return list;
        }
        list.add(date1);
        if (date2 == null || date1.after(date2)) {
            return list;
        }
        while (date1.compareTo(date2) < 0) {
            if (points == 24) {
                date1 = DateUtils.addHours(date1, 1);
            } else if (points == 48) {
                date1 = DateUtils.addMinutes(date1, 30);
            } else if (points == 96) {
                date1 = DateUtils.addMinutes(date1, 15);
            } else {
                return list;
            }
            if (!list.contains(date1)) { // 避免重复数据
                list.add(date1);
            }
        }
        return list;
    }

    /**
     * 获取指定日期去年的日期
     * 
     * @return
     */
    public static String getDateOfLastYear(Date date) {
        // Date Format will be display
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        aGregorianCalendar.setTime(date);
        // Get last month GregorianCalendar object
        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
        // Format the date to get year and month
        String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return currentYearAndMonth;
    }

    /**
     * 按照采集时间把当前时间转发为15分钟，30,45分钟格式
     * 
     * @param startDate
     * @return
     */
    public static Date parseToCollectTime(Date startDate) {
        Calendar cr = Calendar.getInstance();
        cr.setTime(startDate);
        int minuts = cr.get(Calendar.MINUTE);
        if (minuts < 15) {
            minuts = 0;
        } else if (minuts < 30) {
            minuts = 15;
        } else if (minuts < 45) {
            minuts = 30;
        } else if (minuts >= 45) {
            minuts = 45;
        }
        cr.set(Calendar.MINUTE, minuts);
        cr.set(Calendar.SECOND, 0);
        cr.set(Calendar.MILLISECOND, 0);
        return cr.getTime();
    }

    public static String getWeekCN(int week) {
        if (week == 7) {
            return "周日";
        } else if (week == 1) {
            return "周一";
        } else if (week == 2) {
            return "周二";
        } else if (week == 3) {
            return "周三";
        } else if (week == 4) {
            return "周四";
        } else if (week == 5) {
            return "周五";
        } else if (week == 6) {
            return "周六";
        } else {
            return "非法字符";
        }

    }

    public static String convert2String(long time, String format) {
        if (time > 0l) {
            if (StringUtils.isBlank(format)) {
                format = TIME_LONG;
            }

            SimpleDateFormat sf = new SimpleDateFormat(format);
            Date date = new Date(time);
            return sf.format(date);
        }
        return "";
    }

    /**
     * 得到时间点坐标集合，[1,2,3...23,24,....30,31]
     */
    public static List<String> getTimePointList(int maxMonthDay) {
        List<String> datatimeList = new ArrayList<String>();
        for (int i = 1; i <= maxMonthDay; i++) {
            datatimeList.add(String.valueOf(i));
        }
        return datatimeList;
    }

    public static Date getFirstDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static byte[] Cp56time2atoByte(Calendar date) {
        short msec = (short) (date.get(Calendar.SECOND) * 1000 + date.get(Calendar.MILLISECOND));
        byte min = (byte) date.get(Calendar.MINUTE);
        byte hour = (byte) date.get(Calendar.HOUR_OF_DAY);
        ;
        byte day_m = (byte) date.get(Calendar.DAY_OF_MONTH);
        byte day_w = (byte) (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : date.get(Calendar.DAY_OF_WEEK) - 1);
        byte month = (byte) (date.get(Calendar.MONTH) + 1);
        byte year = (byte) (date.get(Calendar.YEAR) - 2000);
        byte[] time = new byte[7];
        time[0] = (byte) (msec & 0xFF);
        time[1] = (byte) ((msec >> 8) & 0xFF);
        time[2] = (byte) (min & 0x3F);
        time[3] = (byte) (hour & 0x1F);
        time[4] = (byte) ((day_m & 0x1F) | (day_w << 5));
        time[5] = month;
        time[6] = year;
        return time;
    }

    public static Calendar Cp56time2atoDate(byte[] buf) {
        if (buf == null || buf.length < 7) {
            return null;
        }
        Calendar date = Calendar.getInstance();
        date.set(ProtocolUtils.Unsignd(buf[6]) + 2000, ProtocolUtils.Unsignd(buf[5]) - 1, ProtocolUtils.Unsignd((byte) (buf[4] & 0x1F)),
                 ProtocolUtils.Unsignd((byte) (buf[3] & 0x1F)), ProtocolUtils.Unsignd((byte) (buf[2] & 0x3F)), ProtocolUtils.byteToShort(buf[1], buf[1]) / 1000);
        return date;
    }

    public static boolean isFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day == 1 ? true : false;
    }
}
