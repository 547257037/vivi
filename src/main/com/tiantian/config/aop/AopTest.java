package com.tiantian.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Aspect
@Component
@Order(-1)
public class AopTest {

     int tag= 0;

    @Pointcut("execution(* com.tiantian.api.dictionaries.dictionariesController.DictionariesController.*(..))")
    public void daoAspect() {
    }
    @Before("daoAspect()")
   public void testBefore(JoinPoint point){

       //第一步查询数据库，放到redis的datasource

       if (tag==0){

           DataSourceContextHolder.setKey("clouddb01");
           System.out.println("111111111111111==================================>"+tag);
           tag=1;

       }else if (tag==1){

           tag=2;
           DataSourceContextHolder.setKey("cloudDB02");
           System.out.println("2222222222222222==================================>"+tag);

       }else if (tag==2){
           SwitchDB.createDataSource("hero2");
           tag=0;
           DataSourceContextHolder.setKey("hero2");
       }
        DynamicDataSource.getDataSourceMap().forEach((x,y)->{
            System.out.println("kkkkkkk==================================>"+x);
        });

//       //获得当前访问的class
//       Class<?> className = point.getTarget().getClass();
//       System.out.println("className==================================>"+className);
//       Repository annotation = className.getAnnotation(Repository.class);
//       if (annotation!=null){
//           //获得访问的方法名
//           String methodName = point.getSignature().getName();
//           //得到方法的参数的类型
//           Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
//         System.out.println("name==================================>"+methodName);
       }
    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        DataSourceContextHolder.clearKey();

    }
   }


