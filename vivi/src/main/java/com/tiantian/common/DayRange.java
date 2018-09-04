package com.tiantian.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tiantian.config.converter.DayRangeConverter;
import com.tiantian.utils.StarvDateUtils;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 * Created by zyx on 2017/6/28.
 */
@JsonDeserialize(converter = DayRangeConverter.class)
@EqualsAndHashCode
public class DayRange {

    /**
     * yyyyMMdd
     */
    private String startDay;

    /**
     * yyyyMMdd
     */
    private String endDay;

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public DayRange(String dayRange) {
        if (dayRange.contains("-")) {
            String[] dayRangeArray = dayRange.split("-");
            this.startDay = dayRangeArray[0];
            this.endDay = dayRangeArray[1];
        } else {
            this.startDay = dayRange;
            this.endDay = dayRange;
        }
    }

    public DayRange(DayRange dayRange) {
        this.startDay = dayRange.getStartDay();
        this.endDay = dayRange.getEndDay();
    }

    public DayRange(String startDay, String endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    /**
     * 只是为了构造方便，把每次都重复的部分放在这里面...
     *
     * @param startDay
     * @param endDay
     */
    public DayRange(DateTime startDay, DateTime endDay) {
        this.startDay = startDay.toString("yyyyMMdd");
        this.endDay = endDay.toString("yyyyMMdd");
    }

    /**
     * 只是为了构造方便，把每次都重复的部分放在这里面...
     *
     * @param startDay
     * @param endDay
     */
    public DayRange(DateTime startDay, DateTime endDay, String pattern) {
        this.startDay = startDay.toString(pattern);
        this.endDay = endDay.toString(pattern);
    }

    public String toStringFormat() {
        if (StringUtils.equals(startDay, endDay)) {
            return startDay.substring(0, 4) + "-" + startDay.substring(4, 6) + "-" + startDay.substring(6);
        }
        return startDay.substring(0, 4) + "-" + startDay.substring(4, 6) + "-" + startDay.substring(6) + ":" +
                endDay.substring(0, 4) + "-" + endDay.substring(4, 6) + "-" + endDay.substring(6);
    }


    /**
     * warning!!!
     * if you modify this method , system will be over!!!
     */
    @Override
    public String toString() {
        return startDay + "-" + endDay;
    }


    /**
     * @return 包含天结束天数的间隔天数
     */
    public int getDaysBetween() {
        return StarvDateUtils.getDaysBetweenOpen(startDay, endDay);
    }

    public boolean isSameDay() {
        return StringUtils.equals(startDay, endDay);
    }
}
