package com.tiantian.api.dictionaries.dictionariesEntity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Hero {

 private String heroName;
    private String heroPassword;
    private Integer heroType;
    private String createTime;
    private Integer heroLv;
    private String updateTime;
    private BigDecimal heroPrice;
    private String imgPath;
    private String describe;
    private String videoPath;
    private MultipartFile[] videoFiles;
    private MultipartFile[] imageFiles;//存放数据

}
