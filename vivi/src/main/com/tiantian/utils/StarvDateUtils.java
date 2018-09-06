package com.tiantian.utils;

import com.google.common.collect.Lists;
import com.tiantian.config.exception.StarvException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zyx on 2017/10/18.
 * 我实在受不了每次写匹配了 靠!
 */
public class StarvDateUtils {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    private static final String[] DATE_FORMATTER = new String[]{"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss" , "yyyy/MM/dd" +
            " HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy/MM/dd HH:mm:ss.SSS" ,"yyyyMMdd HH:mm:ss" ,"yyyyMMddHHmm" ,"yyyyMMdd HH:mm"};

    private static final String[] DAY_FORMATTER = new String[]{"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd"};
    private static final String[] MONTH_FORMATTER = new String[]{"yyyyMM", "yyyy-MM", "yyyy/MM"};

    public static DateTime parseDate(String date) {//这个是带时分秒的
        try {
            return new DateTime(DateUtils.parseDate(date, DATE_FORMATTER));
        } catch (ParseException e) {
            throw new StarvException("日期解析错误 date:" + date);
        }
    }


    public static DateTime parseDay(String day) {//这个是天的
        try {
            return new DateTime(DateUtils.parseDate(day, DAY_FORMATTER));
        } catch (ParseException e) {
            throw new StarvException("日期解析错误 day:" + day);
        }
    }

    public static DateTime parseMonth(String month) {//这个是月的
        try {
            return new DateTime(DateUtils.parseDate(month, MONTH_FORMATTER));
        } catch (ParseException e) {
            throw new StarvException("日期解析错误 day:" + month);
        }
    }

    public static String getYesterdayByDay(String day, String format) {
        return getYesterday(parseDay(day), format);
    }

    public static String getTomorrowByDay(String day, String format) {
        return getTomorrow(parseDay(day), format);
    }

    public static String getYesterdayByDate(String date, String format) {
        return getYesterday(parseDate(date), format);
    }

    public static String formatDayStr(String day, String format) {
        return parseDay(day).toString(format);
    }

    public static String formatDateStr(String date, String format) {
        return parseDate(date).toString(format);
    }

    public static String getYesterday(DateTime datetime, String format) {
        return datetime.minusDays(1).toString(format);
    }

    public static String getTomorrow(DateTime datetime, String format) {
        return datetime.plusDays(1).toString(format);
    }

    public static int dayOfMonth(DateTime date)  {
        return date.get(DateTimeFieldType.dayOfMonth());
    }

    public static int monthOfYear(DateTime date) {
        return date.get(DateTimeFieldType.monthOfYear());
    }

    /**
     * getDaysBetween("20170801", "20170802") -> 1
     *
     * @param startDay 开始时间
     * @param stopDay 结束时间
     * @return 两天间隔多少天
     */
    public static int getDaysBetween(String startDay,String stopDay){
        return Days.daysBetween(parseDay(startDay), parseDay(stopDay)).getDays();
    }

    /**
     * getDaysBetween("20170801", "20170802") -> 2
     *
     * @param startDay 开始时间
     * @param stopDay  结束时间
     * @return 两天间隔多少天
     */
    public static int getDaysBetweenOpen(String startDay, String stopDay) {
        return Days.daysBetween(parseDay(startDay), parseDay(stopDay)).getDays() + 1;
    }

    public static String getMinusDay(String day, String format,int diff){
        return parseDay(day).minusDays(diff).toString(format);
    }
    // 获取上周一到昨天
    public static String getLastWeekMonday(String file) {
        Date date = new Date();
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMATTER[1]);
        Date date1 = new Date();
        date1 = DateUtils.addDays(date, -1);
        String format = sdf.format(date1);
        SimpleDateFormat df = new SimpleDateFormat(DAY_FORMATTER[1]);
        if (StringUtils.isBlank(file)){
            return "\""+ df.format(cal.getTime())+":"+format+"\"";
        }else {
            return  df.format(cal.getTime())+","+format;
        }


    }





    // 获取上月第一天到昨天
    public  static String getLastMonthDayOne(String file ) {
        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMATTER[1]);
        date = DateUtils.addDays(date, -1);
        String format = sdf.format(date);
        if (StringUtils.isBlank(file)){
            return "\""+sdf.format(calendar1.getTime())+":"+format+"\"";
        }else {
            return sdf.format(calendar1.getTime()).substring(0,7);
        }
    }


    //补数据用的日期区间
    public static List<String> days(String dateRange,String json) {

        List<String> days = Lists.newArrayList();
        String startDay = dateRange.split(":")[0];
        String endDay = dateRange.split(":")[1];
        try {
            if(startDay.length() == 8) {
                startDay = df.format(DateUtils.parseDate(startDay,DAY_FORMATTER[1] ));
            }
            if(endDay.length() == 8) {
                endDay = df.format(DateUtils.parseDate(endDay, DAY_FORMATTER[1]));
            }
            DateTime startDayTime = new DateTime(DateUtils.parseDate(startDay, DAY_FORMATTER[1]));
            DateTime endDayTime = new DateTime(DateUtils.parseDate(endDay, DAY_FORMATTER[1]));
            while (startDayTime.isBefore(endDayTime) || startDayTime.isEqual(endDayTime)) {
                if (StringUtils.isBlank(json)) {
                    days.add("\"" + startDayTime.toString(DAY_FORMATTER[1])  + ":"  + startDayTime.toString(DAY_FORMATTER[1]) + "\"");
                }else {
                    days.add( startDayTime.toString(DAY_FORMATTER[1]));
                }
                startDayTime = startDayTime.plusDays(1);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return days;
    }
    //补数据的周区间
    public static List<String> getWeeks(String dateRange,String json) throws ParseException {
        List<String> list = new ArrayList();
        List<String> days = days(dateRange,"file");
        for (String day : days) {
            SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMATTER[1]);
            Date parse = sdf.parse(day);
            Calendar calendar = Calendar.getInstance();//日历对象
            calendar.setTime(parse);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week==2) {
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 6 );
                String format = sdf.format(calendar.getTime());
                if (StringUtils.isBlank(json)) {
                    list.add("\""+sdf.format(parse) + ":"+format+"\"");
                }else {
                    list.add(sdf.format(parse) + "," + format);
                }
            }

        }
        return list;
    }

    /**
     * 获取昨天日期
     * @return
     */
    public static String getCurrentDate(String file){

        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMATTER[1]);
        Date date = new Date();
        date = DateUtils.addDays(date, -1);
        if (StringUtils.isBlank(file)) {
            return "\"" + sdf.format(date) + ":" + sdf.format(date) + "\"";
        }else {
            return sdf.format(date);
        }
    }

    /*
      获取月初和月末
     */
    public static List<String> getMonThs(String dateRange,String json)throws ParseException  {
        List<String> set = new ArrayList<>();
        Calendar cale = null;
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;

        List<String> days = days(dateRange,"file");
        for (String day : days) {
            // 获取前月的第一天
            cale = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMATTER[1]);
            Date parse = sdf.parse(day);
            cale.setTime(parse);
            cale.add(Calendar.MONTH, 0);
            cale.set(Calendar.DAY_OF_MONTH, 1);
            firstday = format.format(cale.getTime());
            // 获取前月的最后一天
            cale = Calendar.getInstance();
            cale.setTime(parse);
            cale.add(Calendar.MONTH, 1);
            cale.set(Calendar.DAY_OF_MONTH, 0);
            lastday = format.format(cale.getTime());
            if (StringUtils.isBlank(json)) {
                set.add("\"" + firstday  + ":"  + lastday + "\"");
            }else {
                set.add( firstday.substring(0,7));
            }
            }
            return set;

    }
}
