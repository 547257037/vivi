package com.tiantian.common;

/**
 * Created by zyx on 2017/10/19.
 */
public class NameValue<K,V> {
    private K name;
    private V value;

    public K getName() {
        return name;
    }

    public void setName(K name) {
        this.name = name;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NameValue() {
    }

    public NameValue(K name, V value) {
        this.name = name;
        this.value = value;
    }


}
