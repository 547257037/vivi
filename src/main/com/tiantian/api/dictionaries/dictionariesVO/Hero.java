package com.tiantian.api.dictionaries.dictionariesVO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Hero {

 private String heroName;
    private String heroPassword;
    private String heroType;
    private String createTime;
    private String heroLv;
    private String updateTime;
    private String heroPrice;
    private String imgPath;
    private String videoPath;
    private MultipartFile[] videofiles;
    private MultipartFile[] imagefiles;//存放数据

}
