package com.tiantian.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author admin
 */
public class StringTransformUtils {

    public static List<Object[]> stringToObjectList(String str) {
        return stringToObjectList(str,",");
    }

    public static List<Object[]> stringToObjectList(String str,String regex) {
        return Arrays.stream(str.split(regex, -1))
                .filter(StringUtils::isNotBlank)
                .map(String::trim)
                .map(x -> new Object[]{x})
                .collect(toList());
    }
}
