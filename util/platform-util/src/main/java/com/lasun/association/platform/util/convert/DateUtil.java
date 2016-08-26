package com.lasun.association.platform.util.convert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Description:日期转换工具类
 */
public class DateUtil extends Date {

    public DateUtil() {
        super();
    }

    /**
     * 日期按照设置的格式转成字符串
     *
     * @param date
     * @param pattern
     * @return 字符串
     */
    public static String dateToString(Date date, String pattern) {
        String strDateTime = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        strDateTime = date == null ? null : formater.format(date);
        return strDateTime;
    }

    /**
     * 日期转成字符串，格式为yyyy-MM-dd
     *
     * @param date
     * @return 字符串
     */
    public static String dateToString(Date date) {
        String _pattern = "yyyy-MM-dd";
        return date == null ? null : dateToString(date, _pattern);
    }

    /**
     * 日期时间转字符串，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return 字符串
     */
    public static String dateTimeToString(Date date) {
        String _pattern = "yyyy-MM-dd HH:mm:ss";
        return date == null ? null : dateToString(date, _pattern);
    }

    /**
     * 字符串按照设置的格式转日期
     *
     * @param str
     * @param pattern
     * @return java.util.Date
     */
    public static Date stringToDate(String str, String pattern) {
        Date dateTime = null;
        try {
            if (str != null && !str.equals("")) {
                SimpleDateFormat formater = new SimpleDateFormat(pattern);
                dateTime = formater.parse(str);
            }
        } catch (Exception ex) {
        }
        return dateTime;
    }

    /**
     * 字符串转日期，日期格式为yyyy-MM-dd
     *
     * @param str
     * @return java.util.Date
     */
    public static Date stringToDate(String str) {
        String _pattern = "yyyy-MM-dd";
        return stringToDate(str, _pattern);
    }

    /**
     * 字符串转换为日期格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param str
     * @return java.util.Date
     */
    public static Date stringToDateTime(String str) {
        String _pattern = "yyyy-MM-dd HH:mm:ss";
        return stringToDate(str, _pattern);
    }

    /**
     * long时间转换为日期
     *
     * @param time
     * @return java.util.Date
     */
    public static Date timeMillisToDate(long time) {
        Date dNow = new Date(time);
        return dNow;
    }

    /**
     * 整型年，月，日 转换成日期
     *
     * @param year
     * @param month
     * @param day
     * @return java.util.Date
     */
    public static Date ymdToDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    /**
     * 取指定日后n天，n允许为负数
     *
     * @param date
     * @param afterDays
     * @return java.util.Date
     */
    public static Date getAfterDay(Date date, int afterDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, afterDays);
        return cal.getTime();
    }

    /**
     * 取指定日后n月,n允许为负数
     *
     * @param date
     * @param afterMonth
     * @return java.util.Date
     */
    public static Date getAfterMonth(Date date, int afterMonth) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MONTH, afterMonth);
        return cal.getTime();
    }

    /**
     * 两个时间相差的天数
     *
     * @param date1
     * @param date2
     * @return int 天数,date2比date1大则为负数
     */
    public static int dateDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
        return i;
    }

    /**
     * 两个时间相差的小时数
     *
     * @param date1
     * @param date2
     * @return int 小时数,date2比date1大则为负数
     */
    public static int hourDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 1000);
        return i;
    }

    /**
     * 两个时间相差的分钟数
     *
     * @param date1
     * @param date2
     * @return int, date2比date1大则为负数
     */
    public static int minDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 1000 / 60);
        return i;
    }

    /**
     * 两个时间相差的秒数
     *
     * @param date1
     * @param date2
     * @return int, date2比date1大则为负数
     */
    public static int secondDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 1000);
        return i;
    }

    /**
     * 两个时间相差的毫秒数
     *
     * @param date1
     * @param date2
     * @return int, date2比date1大则为负数
     */
    public static int timeDiff(Date date1, Date date2) {
        int i = (int) (date1.getTime() - date2.getTime());
        return i;
    }

    /**
     * 获取日期 是星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }

    public static void main(String[] args) {
        Date date = new Date();
        Date startTime = getAfterDay(date, 1);
        String startTimeString = DateUtil.dateToString(startTime);
        Date endTime = getAfterDay(date, 90);
        String endTimeString = DateUtil.dateToString(endTime);
        System.out.println("d1: " + startTimeString + "  d1: " + endTimeString);
    }
}
