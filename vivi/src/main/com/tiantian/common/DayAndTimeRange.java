package com.tiantian.common;

import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zyx on 2017/7/27.
 */
@Data
@ToString
public class DayAndTimeRange {

    private final Set<String> dayRangeSet = new HashSet<>();

    private final Set<String> timeRangeSet = new HashSet<>();

}
