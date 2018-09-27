package com.tiantian.config.redis;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


import java.lang.reflect.Method;

//@Configuration
//@EnableCaching
public class RedisConfig {//extends CachingConfigurerSupport {
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        rcm.setDefaultExpiration(60);//秒
//        //rcm.setExpires();设置缓存区域(按key)的过期时间(以秒为单位)
//        return rcm;
//    }
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            //为给定的方法及其参数生成一个键
//            //格式为：com.frog.mvcdemo.controller.FrogTestController-show-[params]
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuffer sb = new StringBuffer();
//                sb.append(target.getClass().getName());//类名
//                sb.append("-");
//                sb.append(method.getName());//方法名
//                sb.append("-");
//                for (Object param: params ) {
//                    sb.append(param.toString());//参数
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//
//
//    /**
//     * RedisTemplate配置
//     * @param factory
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        //定义value的序列化方式
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
}
