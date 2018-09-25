package com.tiantian.utils;

import com.tiantian.enums.CodeEnum;

public class EnumUtils {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        //所以即便Enum接口中没有values()方法，我们仍然可以通过Class对象取得所有的enum实例
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
