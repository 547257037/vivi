package com.tiantian.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Aspect
@Component
@Order(-1)
public class AopTest {
   @Before("execution(* com.tiantian.api.dictionaries.dictionariesDao.impl..*.*(..))")
   public void testBefore(JoinPoint point){

       //第一步查询数据库，放到redis的datasource

       boolean tag =true;
       if (tag){

           DataSourceContextHolder.setKey("test1");
           tag=false;
       }else {
           DataSourceContextHolder.setKey("test2");
       }
       //获得当前访问的class
       Class<?> className = point.getTarget().getClass();
       System.out.println("className==================================>"+className);
       Repository annotation = className.getAnnotation(Repository.class);
       if (annotation!=null){
           //获得访问的方法名
           String methodName = point.getSignature().getName();
           //得到方法的参数的类型
           Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
         System.out.println("name==================================>"+methodName);
           System.out.println("class==================================>"+getClass());
       }
   }

}
