package com.tiantian.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by zyx on 2017/10/19.
 */
@Data
@AllArgsConstructor
public class NameValueEnable<K,V> {
    private K name;
    private V value;
    private boolean enable;
}
