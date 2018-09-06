package com.tiantian.config.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.tiantian.common.TimeRange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by zyx on 2017/7/3.
 */
@Component
public class TimeRangeConverter  implements Converter {

    @Override
    public Object convert(Object o) {

        // safe convert
        if(!(o instanceof String)){
            return null;
        }

        String source = (String) o;
        if (StringUtils.isNotBlank(source)) {
            String[] times = StringUtils.split(source.replaceAll(":", ""), "-");
            String startTime = times[0];
            //传单天的话 结束时间等于开始时间的23:59:59
            String stopTime = times.length == 2 ?
                    times[1] :
                    startTime;
            return new TimeRange(startTime, stopTime);
        }
        return null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(String.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(TimeRange.class);
    }

}
