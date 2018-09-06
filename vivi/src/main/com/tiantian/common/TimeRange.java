package com.tiantian.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tiantian.config.converter.TimeRangeConverter;
import lombok.Data;

/**
 * Created by zyx on 2017/7/27.
 */
@JsonDeserialize(converter = TimeRangeConverter.class)
@Data
public class TimeRange {

    private String startTime;
    private String endTime;
    private String programName;
    private DayRange dayRange;
    private String day;

    public TimeRange(String timeRange) {
        String[] data = timeRange.split(":");
        this.startTime = data[0];
        this.endTime = data[1];
    }

    public TimeRange(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeRange(String startTime, String endTime, String programName, DayRange dayRange) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.programName = programName;
        this.dayRange = dayRange;
    }

    public String toStringFormat() {
        return startTime.substring(0, 2) + ":" + startTime.substring(2, 4) + ":" + startTime.substring(4)
                + "-" + endTime.substring(0, 2) + ":" + endTime.substring(2, 4) + ":" + endTime.substring(4);
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", programName='" + programName + '\'' +
                ", dayRange=" + dayRange +
                ", day='" + day + '\'' +
                '}';
    }

}
