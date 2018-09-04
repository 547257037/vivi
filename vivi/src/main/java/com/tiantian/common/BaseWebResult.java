package com.tiantian.common;

/**
 * 通用web结果字段
 *
 * @author zyx
 * @date 2018/5/4.
 */
public interface BaseWebResult {

    String getAreaCode();

    void setAreaName(String areaName);

    String getOperator();

    void setOperatorName(String operatorName);

    String getPlatform();

    void setPlatformName(String platformName);

}
