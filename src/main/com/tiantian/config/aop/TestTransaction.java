package com.tiantian.config.aop;

//
//import domain.dao.impl.ExhibitionDao;
//import domain.dbs.DynamicDataSource;
//import domain.dbs.DynamicDataSourceContextHolder;
//import domain.dbs.SwitchDB;
//import domain.domain.DomainResponse;
//import domain.domain.Exhibition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试切库后的事务类
 * @author lxf 2018-09-28
 */
@Service
@Slf4j
public class TestTransaction {
//    @Autowired
//    private ExhibitionDao dao;
//    @Autowired
//    private SwitchDB switchDB;
//
//    @Autowired
//    DynamicDataSource dynamicDataSource;
//
//    public DomainResponse testProcess(int kaiguan, int ljyunId, String dbName){
//        switchDB.change(dbName,ljyunId);
//        //获取当前已有的数据源实例
//        System.out.println("%%%%%%%%"+dynamicDataSource.getDataSourceMap());
//        return process(kaiguan,ljyunId,dbName);
//    }
//
//    /**
//     * 事务测试
//     * 注意：(1)有@Transactional注解的方法，方法内部不可以做切换数据库操作
//     *      (2)在同一个service其他方法调用带@Transactional的方法，事务不起作用，（比如：在本类中使用testProcess调用process()）
//     *         可以用其他service中调用带@Transactional注解的方法，或在controller中调用.
//     * @param kaiguan
//     * @param ljyunId
//     * @param dbName
//     * @return
//     */
//    //propagation 传播行为 isolation 隔离级别  rollbackFor 回滚规则
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
//    public DomainResponse process(int kaiguan, int ljyunId, String dbName ) {
//        String currentKey = DynamicDataSourceContextHolder.getDataSourceKey();
//        log.info("＝＝＝＝＝service当前连接的数据库是:" + currentKey);
//        Exhibition exhibition = new Exhibition();
//        exhibition.setExhibitionName("A-001-003");
//        //return new DomainResponse<String>(1, "新增成功", "");
//        int addRes = dao.insert(exhibition);
//        if(addRes>0 && kaiguan==1){
//            exhibition.setExhibitionName("B-001-002");
//            int addRes2 = dao.insert(exhibition);
//            return new DomainResponse<String>(1, "新增成功", "");
//        }else
//        {
//            Map<String,String> map = new HashMap<>();
//            String a = map.get("hello");
//            //log.info("-----a="+a.replace("a","b"));
//            //手动回滚事务
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return new DomainResponse<String>(0, "新增错误，事务已回滚", "");
//        }
//    }
}