package com.tiantian.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


/**
 * @author 付天
 * @Title: starv-iptv-4
 * @Package com.starv.utilspackage_name
 * @date 2018/4/11 0011下午 4:44
 */
public class ImagsUtils {


@Qualifier("pSql")
@Autowired
private static JdbcTemplate psql;

    public void saveToFile(String destUrl,String name,String filelujing) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            File e=new File(filelujing);
             if(!e.exists()){
               e.mkdir();
             }
            fos = new FileOutputStream(filelujing+"\\+"+name+".jpg");
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
    }
    public static List<ImagsObject> findAllImagsObject() {
        String sql = "select DISTINCT image_url,type,celebrity_id  from media_celebrity_sel  ";
        List<ImagsObject> list = psql.query(sql,new BeanPropertyRowMapper(ImagsObject.class));
        if(list != null && list.size() >= 0){
            return list;
        }
        return null;
    }
    public static void main(String[] args) {
        findAllImagsObject();
        ImagsUtils dw=new ImagsUtils();
        dw.saveToFile("https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48084.jpg","tiantiandagege","f:\\tiantian7");
    }
}

