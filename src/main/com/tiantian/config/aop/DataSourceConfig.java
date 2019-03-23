package com.tiantian.config.aop;




import java.util.HashMap;

import java.util.Map;



import javax.sql.DataSource;


import com.tiantian.common.Jdbc;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;

import org.mybatis.spring.SqlSessionTemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/*

 * 数据源配置抽象类

 */
@MapperScan(basePackages = "com.tiantian.mapper.psql", sqlSessionTemplateRef = "sqlSessionTemplate")
@Configuration
public  class DataSourceConfig {



//    @Autowired
//    private Environment env;
//
//    @Value("${datasources}")
//    private String datasources;

    /*

     * 默认数据源。

     */

    //protected abstract DataSource getDefaultDataSource()

    protected  DataSource getDefaultDataSource(){

        DruidDataSource defaultDS = new DruidDataSource();

        //放入数据源
        defaultDS.setUrl("jdbc:log4jdbc:mysql://localhost:3306/clouddb01");
        defaultDS.setUsername("root");
        defaultDS.setPassword("");
        defaultDS.setDriverClassName("net.sf.log4jdbc.DriverSpy");
        return defaultDS;
    }



    /*

     * 可动态路由的数据源。

     */

    //protected abstract Map<Object, Object> getDataSources();

//    protected  Map<Object, Object> getDataSources(){
//
//        Map<Object, Object> dataSourceMap = DynamicDataSource.getDataSourceMap();
//
//        dataSourceMap.put("default", getDefaultDataSource());
//                //todo 在redis中取,
//                DruidDataSource dataSource = new DruidDataSource();
//                dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/clouddb01");
//                dataSource.setUsername("root");
//                dataSource.setPassword("");
//                dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
////                       new HikariDataSource(dataSource)
//        dataSourceMap.put("cloudDB01", dataSource);
//            DruidDataSource dataSource2 = new DruidDataSource();
//            dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/hero");
//            dataSource.setUsername("root");
//            dataSource.setPassword("");
//            dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
//        dataSourceMap.put("cloudDB02", dataSource2);
//
//        return dataSourceMap;
//
//    }





    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = DynamicDataSource.getDataSourceMap();

        dataSourceMap.put("default", getDefaultDataSource());
        //todo 在redis中取,
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/clouddb01");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
//                       new HikariDataSource(dataSource)
        dataSourceMap.put("cloudDB01", dataSource);
        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setUrl("jdbc:log4jdbc:mysql://localhost:3306/hero");
        dataSource2.setUsername("root");
        dataSource2.setPassword("");
        dataSource2.setDriverClassName("net.sf.log4jdbc.DriverSpy");
        dataSourceMap.put("cloudDB02", dataSource2);
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();

        DataSource ds = getDefaultDataSource();
        dynamicDataSource.setDefaultTargetDataSource( ds );
        dynamicDataSource.setTargetDataSources( dataSourceMap );
        return dynamicDataSource;

    }



    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);

    }



    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/psql/**/*.xml"));
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }
       @Bean
    public Jdbc jdbc(){
        return new Jdbc(dynamicDataSource());
    }


    /**
     * 将动态数据源添加到事务管理器中，并生成新的bean
     * @return the platform transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}

