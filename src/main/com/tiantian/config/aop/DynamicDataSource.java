package com.tiantian.config.aop;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

public class
DynamicDataSource extends AbstractRoutingDataSource {

    private static DynamicDataSource instance;

    private static byte[] lock=new byte[0];

    //用于存储已实例的数据源map
    private static Map<Object,Object> dataSourceMap=new HashMap<Object, Object>();

//这个Map<Object,Object>里面放的是Map<String,DataSource>)
    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {

        super.setTargetDataSources(targetDataSources);

        // 必须添加该句，让方法根据重新赋值的targetDataSource依次根据key关键字
        // 查找数据源,返回DataSource,否则新添加数据源无法识别到
        super.afterPropertiesSet();

    }

    /**
     * 获取存储已实例的数据源map
     * @return
     */
    public static Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }
    /**
     * 是否存在当前key的 DataSource
     * @param key
     * @return 存在返回 true, 不存在返回 false
     */
    public static boolean isExistDataSource(String key) {
        return dataSourceMap.containsKey(key);
    }

    public static synchronized DynamicDataSource getInstance(){

        if(instance==null){

            synchronized (lock){

                if(instance==null){

                    instance=new DynamicDataSource();

                }
            }

        }
        return instance;

    }



    // 实现其抽象方法,

    // 因为在创建DataSource这个方法:determineTargetDataSource()中(上面有分析)

    // 会调用这个key关键字,根据这个key在重新赋值的targetDataSource里面找DataSource
    @Override
    protected Object determineCurrentLookupKey() {

        return DataSourceContextHolder.getKey();

    }



}
