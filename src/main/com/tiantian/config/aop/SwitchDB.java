package com.tiantian.config.aop;

import com.alibaba.druid.pool.DruidDataSource;
import com.tiantian.config.exception.StarvException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 切换数据库类
 * @author lxf 2018-09-28
 */
@Configuration
@Slf4j
public class SwitchDB {
    @Autowired
    private Environment evn;
    //私有库数据源key
    private static String ljyunDataSourceKey = "ljyun_";

    @Autowired
    DynamicDataSource dynamicDataSource;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * 切换数据库对外方法,如果私有库id参数非0,则首先连接私有库，否则连接其他已存在的数据源
     *
     * @param dbName  已存在的数据库源对象
     * @param ljyunId 私有库主键
     * @return 返回当前数据库连接对象对应的key
     */
    public String change(String dbName, String ljyunId) {
        if (StringUtils.isBlank(ljyunId)) {
            toDB(dbName);
        } else {
            toYunDB(ljyunId);
        }
        //获取当前连接的数据源对象的key
        String currentKey = DataSourceContextHolder.getKey();
        log.info("＝＝＝＝＝当前连接的数据库是:" + currentKey);
        return currentKey;
    }

    /**
     * 切换已存在的数据源
     *
     * @param dbName
     */
    private void toDB(String dbName) {
        //如果不指定数据库，则直接连接默认数据库
        String dbSourceKey = dbName.trim().isEmpty() ? "default" : dbName.trim();
        //获取当前连接的数据源对象的key
        String currentKey = DataSourceContextHolder.getKey();
        //如果当前数据库连接已经是想要的连接，则直接返回
        if (currentKey == dbSourceKey) return;
        //判断储存动态数据源实例的map中key值是否存在
        if (DynamicDataSource.isExistDataSource(dbSourceKey)) {
            DataSourceContextHolder.setKey(dbSourceKey);
            log.info("＝＝＝＝＝普通库: " + dbName + ",切换完毕");
        } else {
            log.info("切换普通数据库时，数据源key=" + dbName + "不存在");
        }
    }

    /**
     * 创建新的私有库数据源
     *
     * @param dbSourceKey
     */
    private void toYunDB(String dbSourceKey) {
        //组合私有库数据源对象key

        //获取当前连接的数据源对象的key
        String currentKey = DataSourceContextHolder.getKey();
        if (dbSourceKey == currentKey) return;

        //创建私有库数据源
        createDataSource(dbSourceKey);

        //切换到当前数据源
        DataSourceContextHolder.setKey(dbSourceKey);
        log.info("＝＝＝＝＝私有库: " + dbSourceKey + ",切换完毕");
    }

    /**
     * 创建私有库数据源，并将数据源赋值到targetDataSources中，供后切库用
     *
     * @param dbSourceKey
     * @return
     */
     static DruidDataSource createDataSource(String dbSourceKey) {
        //创建新的数据源
        if (StringUtils.isNotBlank(dbSourceKey)) {
            log.info("动态创建私有库数据时，私有库主键丢失");
        }
//        String yunId = String.valueOf(ljyunId);
//        DruidDataSource dataSource = new DruidDataSource();
//        String prefix = "db.privateDB.";
//        String dbUrl = evn.getProperty(prefix + "url-base")
//                + evn.getProperty(prefix + "host") + ":"
//                + evn.getProperty(prefix + "port") + "/"
//                + evn.getProperty(prefix + "dbname").replace("{id}", yunId) + evn.getProperty(prefix + "url-other");
//        log.info("+++创建云平台私有库连接url = " + dbUrl);
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(evn.getProperty(prefix + "username"));
//        dataSource.setPassword(evn.getProperty(prefix + "password"));
//        dataSource.setDriverClassName(evn.getProperty(prefix + "driver-class-name"));
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/hero2");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
        //将创建的数据源，新增到targetDataSources中
        Map<Object, Object> map = DynamicDataSource.getDataSourceMap();
        if(map.get(dbSourceKey)!=null){
            throw new StarvException("已有改数据源");
        }
        map.put(dbSourceKey, dataSource);
        DynamicDataSource.getInstance().setTargetDataSources(map);
        return dataSource;
    }

}
