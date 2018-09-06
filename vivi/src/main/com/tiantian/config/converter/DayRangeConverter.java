package com.tiantian.config.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.tiantian.common.DayRange;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zyx on 2017/7/3.
 */
public class DayRangeConverter implements Converter {

    private static final int LENGTH = 8;

    @Override
    public Object convert(Object o) {

        // safe convert
        if (!(o instanceof String)) {
            return null;
        }

        String source = (String) o;
        if (StringUtils.isNotBlank(source)) {

            // jianrong 20170808-20170808
            int index = StringUtils.indexOf(source, "-");
            if (index == LENGTH) {
                source = source.replace("-", ":");
            }

            String[] dates = StringUtils.split(source.replaceAll("-", ""), ":");
            String startDay = dates[0];
            String stopDay = dates.length == 2 ?
                    dates[1] :
                    startDay;
            return new DayRange(startDay, stopDay);
        }
        return null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(String.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(DayRange.class);
    }

    public static void main(String[] args) {
        Object convert = new DayRangeConverter().convert("2018-04-17:2018-05-02");
        System.out.println(convert);

    }

}
