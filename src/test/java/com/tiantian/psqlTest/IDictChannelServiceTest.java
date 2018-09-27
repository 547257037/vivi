package com.tiantian.psqlTest;


//import com.starv.entity.StarvColumn;
//import com.starv.entity.StarvColumnSel;
//import com.starv.entity.StarvColumnSelToXl;
//import lombok.ToString;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.*;
//

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 付天
 * @Title: starv-iptv-4
 * @Package com.starv.api.system.service
 * @Description: ${TODO}
 * @date 2018/5/28 0028下午 4:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//
public class IDictChannelServiceTest {

//    @Cacheable(value="thisredis", key="'users_'+#id")
//    public OrderDetail findUser(Integer id) {
//        OrderDetail orderDetail=new OrderDetail();
//        orderDetail.setDetailId("1122");
//        return orderDetail;
//    }
//    @Autowired
//    private JdbcTemplate pg;
//
//    @Test
//    public void f() throws IOException {
//
//
//
//            File fil = new File("E:\\xlsx\\tyy.xlsx");
//            InputStream is = new FileInputStream(fil);
//            List<StarvColumnSelToXl> columns = new ArrayList<>();
//            List<StarvColumn> pColumns = new ArrayList<>();
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
//            // 获取每一个工作薄
//            for (int numSheet = 1; numSheet < 2; numSheet++) {
//                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
//                if (xssfSheet == null) {
//                    continue;
//                }
//                // 获取当前工作薄的每一行
//                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
//                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
//                    if (xssfRow != null) {
//                        XSSFCell one = xssfRow.getCell(0);
//                        //读取第一列数据
//                        XSSFCell two = xssfRow.getCell(1);
//                        //读取第二列数据
//                        XSSFCell three = xssfRow.getCell(2);
//                        //读取第三列数据
//                        //需要转换数据的话直接调用getValue获取字符串
//                        StarvColumnSelToXl starvColumnSelToXl = new StarvColumnSelToXl();
//                        starvColumnSelToXl.setColumn1name(one.toString());
//                        starvColumnSelToXl.setColumn2name(two.toString());
//                        starvColumnSelToXl.setColumnCode(three.getCTCell().getV());
//                        columns.add(starvColumnSelToXl );
//
//                    }
//                }
//
//            }
//            StarvColumn starvColumn1 = new StarvColumn();
//            starvColumn1.setColumnName("海看4k");
//            starvColumn1.setColumnCode("1100000000");
//            starvColumn1.setOperatorLogo(-1);
//            StarvColumn starvColumn2 = new StarvColumn();
//            starvColumn2.setColumnName("海看大片");
//            starvColumn2.setColumnCode("1100000001");
//            starvColumn2.setOperatorLogo(-1);
//            StarvColumn starvColumn3 = new StarvColumn();
//            starvColumn3.setColumnName("海看剧场");
//            starvColumn3.setColumnCode("1100000002");
//            starvColumn3.setOperatorLogo(-1);
//            StarvColumn starvColumn4 = new StarvColumn();
//            starvColumn4.setColumnName("海看少儿");
//            starvColumn4.setColumnCode("1100000003");
//            starvColumn4.setOperatorLogo(-1);
//            StarvColumn starvColumn5 = new StarvColumn();
//            starvColumn5.setColumnName("海看综艺");
//            starvColumn5.setColumnCode("1100000004");
//            starvColumn5.setOperatorLogo(-1);
//            StarvColumn starvColumn6 = new StarvColumn();
//            starvColumn6.setColumnName("海看讲堂");
//            starvColumn6.setColumnCode("1100000005");
//            starvColumn6.setOperatorLogo(-1);
//            StarvColumn starvColumn7 = new StarvColumn();
//            starvColumn7.setColumnName("海看纪实");
//            starvColumn7.setColumnCode("1100000006");
//            starvColumn7.setOperatorLogo(-1);
//            StarvColumn starvColumn8 = new StarvColumn();
//            starvColumn8.setColumnName("海看生活");
//            starvColumn8.setColumnCode("1100000007");
//            starvColumn8.setOperatorLogo(-1);
//            StarvColumn starvColumn9 = new StarvColumn();
//            starvColumn9.setColumnName("海看音乐");
//            starvColumn9.setColumnCode("1100000008");
//            starvColumn9.setOperatorLogo(-1);
//            pColumns.add(starvColumn1);
//            pColumns.add(starvColumn2);
//            pColumns.add(starvColumn3);
//            pColumns.add(starvColumn4);
//            pColumns.add(starvColumn5);
//            pColumns.add(starvColumn6);
//            pColumns.add(starvColumn7);
//            pColumns.add(starvColumn8);
//            pColumns.add(starvColumn9);
//
//
//            for (StarvColumnSelToXl starvColumnSelToXl :columns){
//
//
//                StarvColumn starvColumn10 = new StarvColumn();
//                starvColumn10.setColumnName(starvColumnSelToXl.getColumn2name());
//                starvColumn10.setColumnCode(starvColumnSelToXl.getColumnCode());
//                starvColumn10.setOperatorLogo(-1);
//                pColumns.add(starvColumn10);
//
//            }
//            System.out.println( pColumns);
//            System.out.println( pColumns.size());
//            List<StarvColumnSel> starvColumnSels = new ArrayList();
//
//            for(Integer i=1100000000;i<=1100000008;i++){
//                StarvColumnSel starvColumnlaoda = new StarvColumnSel();
//                starvColumnlaoda.setColumnPCode("1200000000");
//                starvColumnlaoda.setColumnCode(Integer.toString(i));
//
//                starvColumnlaoda.setLeafFlag(0);
//                starvColumnSels.add(starvColumnlaoda);
//
//            }
//            int size0 = starvColumnSels.size();
//
//
//            for(Integer i=1020014001;i<=1020014004;i++){
//                StarvColumnSel starvColumnSeljiang = new StarvColumnSel();
//                starvColumnSeljiang.setColumnPCode("1100000000");
//                starvColumnSeljiang.setColumnCode(Integer.toString(i));
//                starvColumnSeljiang.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljiang);
//
//            }
//            int size1 = starvColumnSels.size();
//            //dapian
//            for(Integer i=1020005001;i<=1020005010;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000001");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
//
//            }
//
//            StarvColumnSel starvColumnSeldapian12 = new StarvColumnSel();
//            starvColumnSeldapian12.setColumnPCode("1100000001");
//            starvColumnSeldapian12.setColumnCode("1020005012");
//            starvColumnSeldapian12.setLeafFlag(1);
//            starvColumnSels.add(starvColumnSeldapian12);
//            int size2 = starvColumnSels.size();
////jucang
//            for(Integer i=1020009001;i<=1020009013;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000002");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
//
//            }
//            int size10 = starvColumnSels.size();
////shaoer
//
//            for(Integer i=1020004001;i<=1020004004;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000003");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
////4
//            }
//            for(Integer i=1020004006;i<=1020004009;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000003");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
////4
//            }
//            for(Integer i=1020004011;i<=1020004014;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000003");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
////4
//            }
//            int size3 = starvColumnSels.size();
////zongyi
//
//            for(Integer i=1020008001;i<=1020008008;i++){
//                StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//                starvColumnSeldapian.setColumnPCode("1100000004");
//                starvColumnSeldapian.setColumnCode(Integer.toString(i));
//                starvColumnSeldapian.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeldapian);
//
//            }
//
//            StarvColumnSel starvColumnSeldapian100 = new StarvColumnSel();
//            starvColumnSeldapian100.setColumnPCode("1100000004");
//            starvColumnSeldapian100.setColumnCode(Integer.toString(1020008010));
//            starvColumnSeldapian100.setLeafFlag(1);
//            starvColumnSels.add(starvColumnSeldapian100);
//            int size4 = starvColumnSels.size();
////jiangtang
//            for(Integer i=1020012002;i<=1020012009;i++){
//                StarvColumnSel starvColumnSeljiang = new StarvColumnSel();
//                starvColumnSeljiang.setColumnPCode("1100000005");
//                starvColumnSeljiang.setColumnCode(Integer.toString(i));
//
//                starvColumnSeljiang.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljiang);
//
//            }
//            int size5 = starvColumnSels.size();
//            StarvColumnSel starvColumnSeljiang2 = new StarvColumnSel();
//            starvColumnSeljiang2.setColumnPCode("1100000005");
//            starvColumnSeljiang2.setColumnCode("1020008011");
//            starvColumnSeljiang2.setLeafFlag(1);
//            starvColumnSels.add(starvColumnSeljiang2);
//
//
//            //jishi
//
//
//
//            for(Integer i=1020007001;i<=1020007009;i++){
//                StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//                starvColumnSeljishi.setColumnPCode("1100000006");
//                starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//                starvColumnSeljishi.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljishi);
//
//            }
//
//
//            for(Integer i=1020007011;i<=1020007013;i++){
//                StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//                starvColumnSeljishi.setColumnPCode("1100000006");
//                starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//                starvColumnSeljishi.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljishi);
//
//            }
//            int size6 = starvColumnSels.size();
//
//            //shenhuo
//            for(Integer i=1020011001;i<=1020011008;i++){
//                StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//                starvColumnSeljishi.setColumnPCode("1100000007");
//                starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//                starvColumnSeljishi.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljishi);
//
//            }
//            int size7 = starvColumnSels.size();
//
////yinyue
//            for(Integer i=1020006001;i<=1020006006;i++){
//                StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//                starvColumnSeljishi.setColumnPCode("1100000008");
//                starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//                starvColumnSeljishi.setLeafFlag(1);
//                starvColumnSels.add(starvColumnSeljishi);
//
//            }
//            StarvColumnSel starvColumnSeljishi88 = new StarvColumnSel();
//            starvColumnSeljishi88.setColumnPCode("1100000008");
//            starvColumnSeljishi88.setColumnCode(Integer.toString(1020006008));
//
//            starvColumnSeljishi88.setLeafFlag(1);
//            starvColumnSels.add(starvColumnSeljishi88);
//            int siz8 = starvColumnSels.size();
//            System.out.println(starvColumnSels);
//Integer i =0;
//        for (StarvColumn starvColumnSel:pColumns){
//            i++;
//            pg.update("INSERT INTO starv_column(column_code,column_name,operator_logo)" +
//                    "VALUES (?,?,?)",starvColumnSel.getColumnCode()==null ?  i:starvColumnSel.getColumnCode() ,starvColumnSel.getColumnName(),starvColumnSel.getOperatorLogo());
//        }
//
////            for (StarvColumnSel starvColumnSel:starvColumnSels){
////         pg.update("INSERT INTO starv_column_sel(column_code,parent_column_code,leaf_flag)" +
////                 "VALUES (?,?,?)",starvColumnSel.getColumnCode()==null ? "":starvColumnSel.getColumnCode(),starvColumnSel.getColumnPCode(),starvColumnSel.getLeafFlag());
////     }
//
//        }
//
//
//
//@Test
//    public void gg() throws IOException {
//
//    File fil = new File("E:\\xlsx\\tyy.xlsx");
//    InputStream is = new FileInputStream(fil);
//    List<StarvColumnSelToXl> columns = new ArrayList<>();
//    List<StarvColumn> pColumns = new ArrayList<>();
//    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
//    // 获取每一个工作薄
//    for (int numSheet = 2; numSheet < 3; numSheet++) {
//        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
//        if (xssfSheet == null) {
//            continue;
//        }
//        // 获取当前工作薄的每一行
//        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
//            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
//            if (xssfRow != null) {
//                XSSFCell one = xssfRow.getCell(0);
//                //读取第一列数据
//                XSSFCell two = xssfRow.getCell(1);
//                //读取第二列数据
//                XSSFCell three = xssfRow.getCell(2);
//                //读取第三列数据
//                //需要转换数据的话直接调用getValue获取字符串
//                StarvColumnSelToXl starvColumnSelToXl = new StarvColumnSelToXl();
//                starvColumnSelToXl.setColumn1name(one.toString());
//                starvColumnSelToXl.setColumn2name(two.toString());
//                starvColumnSelToXl.setColumnCode(three.getCTCell().getV());
//                columns.add(starvColumnSelToXl );
//
//            }
//        }
//
//    }
//
//
//
//    StarvColumn starvColumn2 = new StarvColumn();
//    starvColumn2.setColumnName("海看大片");
//    starvColumn2.setColumnCode("1100000009");
//    starvColumn2.setOperatorLogo(-2);
//    StarvColumn starvColumn3 = new StarvColumn();
//    starvColumn3.setColumnName("海看剧场");
//    starvColumn3.setColumnCode("1100000010");
//    starvColumn3.setOperatorLogo(-2);
//    StarvColumn starvColumn4 = new StarvColumn();
//    starvColumn4.setColumnName("海看少儿");
//    starvColumn4.setColumnCode("1100000011");
//    starvColumn4.setOperatorLogo(-2);
//    StarvColumn starvColumn5 = new StarvColumn();
//    starvColumn5.setColumnName("海看综艺");
//    starvColumn5.setColumnCode("1100000012");
//    starvColumn5.setOperatorLogo(-2);
//    StarvColumn starvColumn6 = new StarvColumn();
//    starvColumn6.setColumnName("海看生活");
//    starvColumn6.setColumnCode("1100000013");
//    starvColumn6.setOperatorLogo(-2);
//    StarvColumn starvColumn7 = new StarvColumn();
//    starvColumn7.setColumnName("海看纪实");
//    starvColumn7.setColumnCode("1100000014");
//    starvColumn7.setOperatorLogo(-2);
//    StarvColumn starvColumn8 = new StarvColumn();
//    starvColumn8.setColumnName("海看讲堂");
//    starvColumn8.setColumnCode("1100000015");
//    starvColumn8.setOperatorLogo(-2);
//    StarvColumn starvColumn9 = new StarvColumn();
//    starvColumn9.setColumnName("海看音乐");
//    starvColumn9.setColumnCode("1100000016");
//    starvColumn9.setOperatorLogo(-2);
//
//    pColumns.add(starvColumn2);
//    pColumns.add(starvColumn3);
//    pColumns.add(starvColumn4);
//    pColumns.add(starvColumn5);
//    pColumns.add(starvColumn6);
//    pColumns.add(starvColumn7);
//    pColumns.add(starvColumn8);
//    pColumns.add(starvColumn9);
//
//
//    for (StarvColumnSelToXl starvColumnSelToXl :columns){
//
//
//        StarvColumn starvColumn10 = new StarvColumn();
//        starvColumn10.setColumnName(starvColumnSelToXl.getColumn2name());
//        starvColumn10.setColumnCode(starvColumnSelToXl.getColumnCode());
//        starvColumn10.setOperatorLogo(-2);
//        pColumns.add(starvColumn10);
//
//    }
//    System.out.println( pColumns);
//    System.out.println( pColumns.size());
//    List<StarvColumnSel> starvColumnSels = new ArrayList();
//
//    for(Integer i=1100000009;i<=1100000016;i++){
//        StarvColumnSel starvColumnlaoda = new StarvColumnSel();
//        starvColumnlaoda.setColumnPCode("1200000000");
//        starvColumnlaoda.setColumnCode(Integer.toString(i));
//
//        starvColumnlaoda.setLeafFlag(0);
//        starvColumnSels.add(starvColumnlaoda);
//
//    }
//    int size0 = starvColumnSels.size();
//
////海看
//    for(Integer i=1001016001;i<=1001016011;i++){
//        StarvColumnSel starvColumnSeljiang = new StarvColumnSel();
//        starvColumnSeljiang.setColumnPCode("1100000009");
//        starvColumnSeljiang.setColumnCode(Integer.toString(i));
//        starvColumnSeljiang.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeljiang);
//
//    }
//    int size1 = starvColumnSels.size();
//
//
//    //d剧场
//    for(Integer i=1001015001;i<=1001015008;i++){
//        StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//        starvColumnSeldapian.setColumnPCode("1100000010");
//        starvColumnSeldapian.setColumnCode(Integer.toString(i));
//        starvColumnSeldapian.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeldapian);
//
//    }
//    for(Integer i=1001015010;i<=1001015011;i++) {
//        StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//        starvColumnSeldapian.setColumnPCode("1100000010");
//        starvColumnSeldapian.setColumnCode(Integer.toString(i));
//        starvColumnSeldapian.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeldapian);
//    }
//
//
//    StarvColumnSel starvColumnSeldapian12 = new StarvColumnSel();
//    starvColumnSeldapian12.setColumnPCode("1100000010");
//    starvColumnSeldapian12.setColumnCode("1001015013");
//    starvColumnSeldapian12.setLeafFlag(1);
//    starvColumnSels.add(starvColumnSeldapian12);
//    int size2 = starvColumnSels.size();
////shaoer
//    for(Integer i=1001014001;i<=1001014008;i++){
//        StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//        starvColumnSeldapian.setColumnPCode("1100000011");
//        starvColumnSeldapian.setColumnCode(Integer.toString(i));
//        starvColumnSeldapian.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeldapian);
//
//    }
//    StarvColumnSel starvColumnSeldapianshaoer = new StarvColumnSel();
//    starvColumnSeldapianshaoer.setColumnPCode("1100000011");
//    starvColumnSeldapianshaoer.setColumnCode("1001014011");
//    starvColumnSeldapianshaoer.setLeafFlag(1);
//    starvColumnSels.add(starvColumnSeldapianshaoer);
//
//    int size10 = starvColumnSels.size();
////综艺
//
//    for(Integer i=1001007003;i<=1001007009;i++){
//        StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//        starvColumnSeldapian.setColumnPCode("1100000012");
//        starvColumnSeldapian.setColumnCode(Integer.toString(i));
//        starvColumnSeldapian.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeldapian);
////4
//    }
//    StarvColumnSel starvColumnSeldapianszhongyi = new StarvColumnSel();
//    starvColumnSeldapianszhongyi.setColumnPCode("1100000012");
//    starvColumnSeldapianszhongyi.setColumnCode("1001007001");
//    starvColumnSeldapianszhongyi.setLeafFlag(1);
//    starvColumnSels.add(starvColumnSeldapianszhongyi);
//
////生活
//
//    for(Integer i=1001012002;i<=1001012007;i++){
//        StarvColumnSel starvColumnSeldapian = new StarvColumnSel();
//        starvColumnSeldapian.setColumnPCode("1100000013");
//        starvColumnSeldapian.setColumnCode(Integer.toString(i));
//        starvColumnSeldapian.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeldapian);
//
//    }
//
//    StarvColumnSel starvColumnSeldapian100 = new StarvColumnSel();
//    starvColumnSeldapian100.setColumnPCode("1100000013");
//    starvColumnSeldapian100.setColumnCode("1001007010");
//    starvColumnSeldapian100.setLeafFlag(1);
//    starvColumnSels.add(starvColumnSeldapian100);
//    int size4 = starvColumnSels.size();
//
////纪实
//    for(Integer i=1001013001;i<=1001013013;i++){
//        StarvColumnSel starvColumnSeljiang = new StarvColumnSel();
//        starvColumnSeljiang.setColumnPCode("1100000014");
//        starvColumnSeljiang.setColumnCode(Integer.toString(i));
//
//        starvColumnSeljiang.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeljiang);
//
//    }
//
//
//
//    //海看讲堂
//
//
//
//    for(Integer i=1001005001;i<=1001005009;i++){
//        StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//        starvColumnSeljishi.setColumnPCode("1100000015");
//        starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//        starvColumnSeljishi.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeljishi);
//
//    }
//
//
//
//
////yinyue
//    for(Integer i=1001006003;i<=1001006005;i++){
//        StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//        starvColumnSeljishi.setColumnPCode("1100000016");
//        starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//        starvColumnSeljishi.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeljishi);
//
//    }
//    for(Integer i=1001006007;i<=1001006009;i++){
//        StarvColumnSel starvColumnSeljishi = new StarvColumnSel();
//        starvColumnSeljishi.setColumnPCode("1100000016");
//        starvColumnSeljishi.setColumnCode(Integer.toString(i));
//
//        starvColumnSeljishi.setLeafFlag(1);
//        starvColumnSels.add(starvColumnSeljishi);
//
//    }
//    StarvColumnSel starvColumnSeldapian11 = new StarvColumnSel();
//    starvColumnSeldapian11.setColumnPCode("1100000016");
//    starvColumnSeldapian11.setColumnCode("1001006001");
//    starvColumnSeldapian11.setLeafFlag(1);
//    starvColumnSels.add(starvColumnSeldapian11);
//
//
//    int siz8 = starvColumnSels.size();
//    System.out.println(starvColumnSels);
//
//
//
//
//
//
//
//
//
//
//    Integer i =80;
//    for (StarvColumn starvColumnSel:pColumns){
//        i++;
//        pg.update("INSERT INTO starv_column(column_code,column_name,operator_logo)" +
//                "VALUES (?,?,?)",starvColumnSel.getColumnCode()==null ?  i:starvColumnSel.getColumnCode() ,starvColumnSel.getColumnName(),starvColumnSel.getOperatorLogo());
//    }
//
////    for (StarvColumnSel starvColumnSel:starvColumnSels){
////        pg.update("INSERT INTO starv_column_sel(column_code,parent_column_code,leaf_flag)" +
////                "VALUES (?,?,?)",starvColumnSel.getColumnCode()==null ? "":starvColumnSel.getColumnCode(),starvColumnSel.getColumnPCode(),starvColumnSel.getLeafFlag());
////    }
//}
    }
