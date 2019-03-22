package com.tiantian.config.datasource;

import com.tiantian.common.Jdbc;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author zyx
 * @date 2018/3/27.
 */
//@Configuration
//@MapperScan(basePackages = "com.tiantian.mapper.psql", sqlSessionTemplateRef = "pSqlSessionTemplate")
public class PSqlDataSourceConfig {
    /**
     * 配置psql数据
     */
    /*
    * @Primary：在众多相同的bean中，优先选择用@Primary注解的bean（该注解加在各个bean上）
@Qualifier：在众多相同的bean中，@Qualifier指定需要注入的bean（该注解跟随在@Autowired后）
    * */
//    @Bean
//    @Primary
//    @ConfigurationProperties( "spring.pg")
    public HikariConfig pSqlDataSourceProperties() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource pSqlDataSource() {
        return new HikariDataSource(pSqlDataSourceProperties());
    }


//    @Primary
//    @Bean(name = "pSql")
    public JdbcTemplate pSqlJdbcTemplate() {
        return new JdbcTemplate(pSqlDataSource());
    }

//    @Primary
//    @Bean(name = "pSqlName")
    public NamedParameterJdbcTemplate mysqlNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(pSqlJdbcTemplate());
    }

//    @Bean
    public Jdbc jdbc(){
        return new Jdbc(pSqlDataSource());
    }

//    @Bean(name = "pSqlSessionFactoryBean")
    public SqlSessionFactory pSqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(pSqlDataSource());

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/psql/**/*.xml"));
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean(name = "pSqlSessionTemplate")
    public SqlSessionTemplate pSqlSessionTemplate(@Qualifier("pSqlSessionFactoryBean") SqlSessionFactory
                                                            sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(pSqlDataSource());
    }
}
