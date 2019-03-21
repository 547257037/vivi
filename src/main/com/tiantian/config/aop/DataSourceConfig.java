package com.tiantian.config.aop;




import java.util.HashMap;

import java.util.Map;



import javax.sql.DataSource;



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
        defaultDS.setUrl("jdbc:log4jdbc:mysql://localhost:3306/cloudDB01");
        defaultDS.setUsername("root");
        defaultDS.setPassword("");
        defaultDS.setDriverClassName("net.sf.log4jdbc.DriverSpy");




        return defaultDS;

    }



    /*

     * 可动态路由的数据源。

     */

    //protected abstract Map<Object, Object> getDataSources();

    protected  Map<Object, Object> getDataSources(){

        Map<Object,Object> map = new HashMap();


                //todo 在redis中取,
                DruidDataSource dataSource = new DruidDataSource();
                dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/cloudDB01");
                dataSource.setUsername("root");
                dataSource.setPassword("");
                dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
                map.put("cloudDB01", dataSource);
                DruidDataSource dataSource2 = new DruidDataSource();
                dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/cloudDB01");
                dataSource.setUsername("root");
                dataSource.setPassword("");
                dataSource.setDriverClassName("net.sf.log4jdbc.DriverSpy");
                map.put("cloudDB01", dataSource);

        return map;

    }





    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();



        Map<Object, Object> dataSources = getDataSources();

        if (dataSources.size() > 0) {

            dynamicDataSource.setTargetDataSources( dataSources );

        }

        DataSource ds = getDefaultDataSource();

        if (ds != null) {
            dynamicDataSource.setDefaultTargetDataSource( ds );
        }

        return dynamicDataSource;

    }



    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);

    }



//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
//
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//
//        bean.setDataSource(dynamicDataSource);
//
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources( getMapperLocation() ));
//
//        return bean.getObject();
//
//    }
    @Bean
    public SqlSessionFactory pSqlSessionFactoryBean(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/psql/**/*.xml"));
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

}

