package com.tiantian.utils;

import com.tiantian.common.DayAndTimeRange;
import com.tiantian.common.DayRange;
import com.tiantian.common.TimeRange;
import com.tiantian.config.exception.StarvException;
import com.tiantian.enums.DayInterval;
import lombok.NonNull;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.Assert;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by zyx on 2017/7/27.
 * timeRange转换器
 */
public class RangeUtils {


    private static final Map<TimeInterval, Integer> DATE_INTERVAL_MAP = new HashMap<TimeInterval, Integer>() {
        {
            put(TimeInterval.A_SECOND,1000);
            put(TimeInterval.ONE_MINUTE, 60 * 1000);
            put(TimeInterval.FIVE_MINUTE, 5 * 60 * 1000);
            put(TimeInterval.TEN_MINUTE, 10 * 60 * 1000);
            put(TimeInterval.THIRTY_MINUTE, 30 * 60 * 1000);
            put(TimeInterval.HOUR, 60 * 60 * 1000);
        }
    };
    private static final String YYYY_MM_DD = "yyyyMMdd";
    private static final String HHMMSS = "HHmmss";

    /**
     * 用来把dayRange的字符串反序列为DateTime类型的，这样复用一下
     */
    private static DateTimeFormatter DAY_FORMATTER = DateTimeFormat.forPattern(YYYY_MM_DD);
    private static DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern(HHMMSS);
    private static LocalTime ZERO_TIME = LocalTime.parse("000000", TIME_FORMATTER);

//    public static DayAndTimeRange buildDateTimeRange(List<StarvEpg> epgList, boolean programGroupFlag,
//                                            @Nullable DayInterval dayInterval, @Nullable TimeInterval timeInterval)  {
//        DayAndTimeRange dateTimeRange = new DayAndTimeRange();
//        Set<String> dayRangeSet = dateTimeRange.getDayRangeSet();
//        Set<String> timeRangeSet = dateTimeRange.getTimeRangeSet();
//        //最大天数
//        String stopDay = epgList.stream().map(StarvEpg::getDt).max(String::compareTo).orElseThrow(errorHandler());
//        //最小天数
//        String startDay = epgList.stream().map(StarvEpg::getDt).min(String::compareTo).orElseThrow(errorHandler());
//        //如果是流水的话 天数只能按单天切
//        if (!programGroupFlag) {
//
//            epgList.stream()
//                    //按天分组
//                    .collect(groupingBy(StarvEpg::getDt))
//                    .forEach((day, epgListForDay) -> {
//                        DayRange dayRange = new DayRange(day, day);
//                        dayRangeList.add(dayRange);
//                        epgListForDay.forEach(epg -> {
//                            splitTime(timeInterval, timeRangeList,
//                                    new TimeRange(epg.getStartTime(), epg.getEndTime()),
//                                    dayRange,
//                                    epg.getProgramName());
//                        });
//                    });
//
//        } else {//合并的话忽略时间切分 只能按天切
//            splitDay(dayInterval, dayRangeList, new DayRange(startDay, stopDay));
//        }
//        return dateTimeRange;
//    }

    public static DayAndTimeRange buildDateTimeRange(@NonNull DayRange dayRange, @Nullable TimeRange timeRange,
                                                     @Nullable DayInterval dayInterval, @Nullable TimeInterval timeInterval) {
        if (timeRange == null) {
            timeRange = new TimeRange("000000", "235959");
        }
        //切分粒度
        if (timeInterval == null) {
            timeInterval = TimeInterval.NONE;
        }
        if (dayInterval == null) {
            dayInterval = DayInterval.NONE;
        }

        return flatDateList(dayRange, timeRange, dayInterval, timeInterval);
    }


    private static Supplier<StarvException> errorHandler() {
        return () -> new StarvException("没有匹配到epg的天数");
    }

    /**
     * @param startDay 20170701 yyyyMMdd
     * @param stopDay  20170703 yyyyMMdd
     * @return ["20170701","20170702","20170703"]
     */
    public static List<String> getBetweenDayList(String startDay, String stopDay) {
        List<String> list = new ArrayList<>();
        DateTime startDate = StarvDateUtils.parseDay(startDay);
        DateTime stopDate = StarvDateUtils.parseDay(stopDay);
        while (!startDate.isAfter(stopDate)) {
            list.add(startDate.toString(YYYY_MM_DD));
            startDate = startDate.plusDays(1);
        }
        return list;
    }

    /**
     * @return 总秒数
     */
    public static int betweenSeconds(TimeRange timeRange) {
        String startTime = timeRange.getStartTime();
        String stopTime = timeRange.getEndTime();
        int seconds;
        try {
            seconds = Seconds.secondsBetween(new DateTime(DateUtils.parseDate(startTime, HHMMSS)),
                    new DateTime(DateUtils.parseDate(stopTime, HHMMSS))).getSeconds();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new StarvException("时间转换异常");
        }

        return seconds;
    }

    private static DayAndTimeRange flatDateList(DayRange dayRange, TimeRange timeRange, DayInterval
            dayInterval, TimeInterval timeInterval) {

        DayAndTimeRange dayAndTimeRange = new DayAndTimeRange();
        Set<String> dayRangeSet = dayAndTimeRange.getDayRangeSet();
        Set<String> timeRangeSet = dayAndTimeRange.getTimeRangeSet();


        splitDay(dayInterval, dayRangeSet, dayRange);

        splitTime(timeInterval, timeRangeSet, timeRange, null, null);


        return dayAndTimeRange;
    }

    private static void splitDay(DayInterval dayInterval,
                                 Set<String> dayRangeSet, DayRange dayRange) {
        String startDay = dayRange.getStartDay();
        String stopDay = dayRange.getEndDay();
        DateTime startDateTime = StarvDateUtils.parseDay(startDay);
        DateTime stopDateTime = StarvDateUtils.parseDay(stopDay);
        if (startDateTime.isAfter(stopDateTime)) {
            throw new StarvException("开始天数不能小于结束天数 startDateTime:" + startDay + ",stopDateTime:" + stopDay);
        }
        DateTime startTmpTime;
        DateTime stopTmpTime;
        if (dayInterval != DayInterval.NONE) {
            //这里切分时 按自然周切
            if (dayInterval == DayInterval.WEEK) {
                //将开始时间调至这周日
                startTmpTime = startDateTime.withDayOfWeek(7);
                stopTmpTime = stopDateTime;
                //测试时间段是否在一周内 直接add 结束
                if (startTmpTime.isEqual(stopTmpTime)
                        || startTmpTime.isAfter(stopTmpTime)) {
                    addDayRangeSet(dayRangeSet, startDateTime, stopDateTime);
                } else { //跨周的情况
                    addDayRangeSet(dayRangeSet, startDateTime, startTmpTime);
                    //调至周一
                    startTmpTime = startTmpTime.plusDays(1);
                    //调至周日
                    stopTmpTime = startTmpTime.withDayOfWeek(7);
                    while (stopTmpTime.isBefore(stopDateTime) || stopTmpTime.isEqual(stopDateTime)) {
                        addDayRangeSet(dayRangeSet, startTmpTime, stopTmpTime);
                        startTmpTime = startTmpTime.plusWeeks(1);
                        //调至周日
                        stopTmpTime = startTmpTime.withDayOfWeek(7);
                    }
                    if (Weeks.weeksBetween(stopDateTime, stopTmpTime).getWeeks() < 1) {
                        addDayRangeSet(dayRangeSet, startTmpTime, stopDateTime);
                    }
                }
            } else if (dayInterval == DayInterval.MONTH) {
                startTmpTime = startDateTime;
                int months = Months.monthsBetween(startDateTime, stopDateTime).getMonths();
                if (months == 0) {
                    addDayRangeSet(dayRangeSet, startTmpTime, stopDateTime);
                } else {
                    for (int i = 0; i <= months; i++) {
                        if (i == 0) {
                            addDayRangeSet(dayRangeSet, startTmpTime, startTmpTime.plusMonths(1).withDayOfMonth(1)
                                    .minusDays(1));
                        } else if (i == months) {
                            addDayRangeSet(dayRangeSet, startTmpTime, stopDateTime);
                        } else {
                            addDayRangeSet(dayRangeSet, startTmpTime, startTmpTime.plusMonths(1).withDayOfMonth(1).minusDays(1));
                        }
                        startTmpTime = startTmpTime.plusMonths(1).withDayOfMonth(1);
                    }
                }
            } else if (dayInterval == DayInterval.YEAR) {
                startTmpTime = startDateTime;
                int years = Years.yearsBetween(startDateTime, stopDateTime).getYears();
                if (years == 0) {
                    addDayRangeSet(dayRangeSet, startTmpTime, stopDateTime);
                } else {
                    for (int i = 0; i <= years; i++) {
                        if (i == 0) {
                            addDayRangeSet(dayRangeSet, startTmpTime, startTmpTime.plusYears(1).withDayOfYear(1).minusDays(1));
                        } else if (i == years) {
                            addDayRangeSet(dayRangeSet, startTmpTime, stopDateTime);
                        } else {
                            addDayRangeSet(dayRangeSet, startTmpTime, startTmpTime.plusYears(1).withDayOfYear(1).minusDays(1));
                        }
                        startTmpTime = startTmpTime.plusYears(1).withDayOfYear(1);
                    }
                }
            } else if (dayInterval == DayInterval.DAY) {
                startTmpTime = startDateTime;
                while (startTmpTime.isEqual(stopDateTime) || !startTmpTime.plusDays(1).isAfter(stopDateTime)) {
                    String day = startTmpTime.toString(YYYY_MM_DD);
                    dayRangeSet.add(day + "-" + day);
                    startTmpTime = startTmpTime.plusDays(1);
                }
            }
        } else {
            addDayRangeSet(dayRangeSet, startDateTime, stopDateTime);
        }
    }

    private static void splitTime(TimeInterval timeInterval, Set<String> timeRangeSet
            , TimeRange timeRange, DayRange dayRange, String programName) {

        String startTime = timeRange.getStartTime();
        String stopTime = timeRange.getEndTime();
        LocalTime startDateTime = LocalTime.parse(startTime, TIME_FORMATTER);
        LocalTime stopDateTime = LocalTime.parse(stopTime, TIME_FORMATTER);


        if (startDateTime.isAfter(stopDateTime)) {
            throw new StarvException("开始时间不能小于结束时间");
        }

        //天以下的粒度
        if (timeInterval != TimeInterval.NONE) {
            Integer duration = DATE_INTERVAL_MAP.get(timeInterval);
            do {
          
                addTimeRangeSet(timeRangeSet, startDateTime, startDateTime.plusMillis(duration));
                startDateTime = startDateTime.plusMillis(duration);
                if (startDateTime.isEqual(ZERO_TIME)) {
                    timeRangeSet.remove(startDateTime.minusMillis(duration).toString(HHMMSS)+":000000");
                    addTimeRangeSet(timeRangeSet, startDateTime.minusMillis(duration), stopDateTime);
                    break;
                }
            } while (startDateTime.isBefore(stopDateTime));
        } else {
            addTimeRangeSet(timeRangeSet, startDateTime, stopDateTime);
        }
        
    }


    private static void addDayRangeSet(Set<String> dayRangeSet, DateTime startDateTime, DateTime stopDateTime) {
        dayRangeSet.add(startDateTime.toString(YYYY_MM_DD) + "-" + stopDateTime.toString(YYYY_MM_DD));
    }

    private static void addTimeRangeSet(Set<String> timeRangeSet, LocalTime startDateTime, LocalTime stopDateTime) {
        timeRangeSet.add(startDateTime.toString(HHMMSS) + ":" + stopDateTime.toString(HHMMSS));

    }


    /**
     * 日期粒度的切片
     * <p>
     * NOTE:
     * 两头不够一个自然周的天数也会被保存
     * <p>
     * <p>
     * 写代码就像写诗，苦苦追寻浪漫的感觉。
     *
     * @param dayRange
     * @param dayInterval
     * @return
     */
    public static List<DayRange> sliceDayRange(DayRange dayRange, DayInterval dayInterval) {

        List<DayRange> resultDayRangeList = new ArrayList<>();

        // 不切分
        if (dayInterval == DayInterval.NONE) {
            resultDayRangeList.add(dayRange);
            return resultDayRangeList;
        }

        DateTime startDay = DAY_FORMATTER.parseDateTime(dayRange.getStartDay());
        DateTime endDay = DAY_FORMATTER.parseDateTime(dayRange.getEndDay());

        // 按日切分
        if (dayInterval == DayInterval.DAY) {
            while (!startDay.isAfter(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, startDay));
                startDay = startDay.plusDays(1);
            }
            return resultDayRangeList;
        }

        // 周
        if (dayInterval == DayInterval.WEEK) {

            // 如果开始日期和结束日期在一周的话
            if (startDay.withDayOfWeek(7).plusDays(1).isAfter(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, endDay));
                return resultDayRangeList;
            }

            // 处理不在一周的情况
            resultDayRangeList.add(new DayRange(startDay, startDay.withDayOfWeek(7)));
            startDay = startDay.plusWeeks(1).withDayOfWeek(1);
            while (startDay.withDayOfWeek(7).isBefore(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, startDay.withDayOfWeek(7)));
                startDay = startDay.plusWeeks(1);
            }
            resultDayRangeList.add(new DayRange(startDay, endDay));
            return resultDayRangeList;
        }

        // 月
        if (dayInterval == DayInterval.MONTH) {

            // 如果开始日期和结束日期在一个月的话
            if (startDay.dayOfMonth().withMaximumValue().plusDays(1).isAfter(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, endDay));
                return resultDayRangeList;
            }

            // 处理不在一个月的情况
            resultDayRangeList.add(new DayRange(startDay, startDay.dayOfMonth().withMaximumValue()));
            startDay = startDay.plusMonths(1).withDayOfMonth(1);
            while (startDay.dayOfMonth().withMaximumValue().isBefore(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, startDay.dayOfMonth().withMaximumValue()));
                startDay = startDay.plusMonths(1);
            }
            resultDayRangeList.add(new DayRange(startDay, endDay));
            return resultDayRangeList;
        }

        // 年
        if (dayInterval == DayInterval.YEAR) {

            // 如果开始日期和结束日期在一年的话
            if (startDay.dayOfYear().withMaximumValue().plusDays(1).isAfter(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, endDay));
                return resultDayRangeList;
            }

            // 处理不在一年的情况
            resultDayRangeList.add(new DayRange(startDay, startDay.dayOfYear().withMaximumValue()));
            startDay = startDay.plusYears(1).withDayOfYear(1);
            while (startDay.dayOfYear().withMaximumValue().isBefore(endDay)) {
                resultDayRangeList.add(new DayRange(startDay, startDay.dayOfYear().withMaximumValue()));
                startDay = startDay.plusYears(1);
            }
            resultDayRangeList.add(new DayRange(startDay, endDay));
            return resultDayRangeList;
        }

        return resultDayRangeList;
    }


    //按自然周或自然月切割时间
    public List<DayRange> splitDayRangeByNative(DayRange dayRange, DayInterval dayInterval) {
        Assert.notNull(dayRange, "dayRange is not be null");
        DateTime startDay = StarvDateUtils.parseDay(dayRange.getStartDay());
        DateTime stopDay = StarvDateUtils.parseDay(dayRange.getEndDay());
        if (startDay.isAfter(stopDay)) {
            throw new StarvException("开始时间不能小于结束时间");
        }
        if (dayInterval == DayInterval.WEEK) {
            DateTime firstMinDay = startDay.dayOfWeek().withMinimumValue();
            DateTime lastMaxDay = stopDay.dayOfWeek().withMaximumValue();
            return sliceDayRange(new DayRange(firstMinDay, lastMaxDay), dayInterval);
        } else if (dayInterval == DayInterval.MONTH) {
            DateTime firstMinDay = startDay.dayOfMonth().withMinimumValue();
            DateTime lastMaxDay = stopDay.dayOfMonth().withMaximumValue();
            return sliceDayRange(new DayRange(firstMinDay, lastMaxDay), dayInterval);
        } else {
            throw new StarvException("只能按周和月切割");
        }
    }


}
