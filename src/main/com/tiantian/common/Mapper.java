package com.tiantian.common;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * Created by zyx on 2017/11/21.
 * spring 提供的这个类名字太长了 手酸了
 */
public class Mapper<T> extends BeanPropertyRowMapper<T> {
    public Mapper() {
        super();
    }

    public Mapper(Class<T> mappedClass) {
        super(mappedClass);
    }

    public Mapper(Class<T> mappedClass, boolean checkFullyPopulated) {
        super(mappedClass, checkFullyPopulated);
    }
}
