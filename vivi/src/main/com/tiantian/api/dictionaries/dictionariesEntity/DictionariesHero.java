package com.tiantian.api.dictionaries.dictionariesEntity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DictionariesHero {
    private String heroName;
    private Integer heroPassword;
    private Integer heroType;
    private String createTime;
    private String updateTime;
    private Integer heroLv;
    private BigDecimal heroPrice;
    private String imgPath;
    private String videoPath;

}
