package com.tiantian.enums;

/**
 * @author liwenlong
 * @Title:
 * @Package
 * @Description:
 * @date 2018/08/16 10:29
 */
public enum  SubscribeIndex {
    stbNum("播放户数"),
    playTime("点播次数");

    private String description;
    SubscribeIndex(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
