package com.tiantian.enums;

/**
 * @author 董建
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/3010:29
 */
public enum LiveIndex {

    audienceRating("收视率"), //收视率 总户数 收视时长
    marketShare("收视份额"), //收视份额 收视时长 所有频道的收视时长
    stbNum("直播用户数"), //到达数
    arrivalRate("到达率"), //到达率 总户数
    viewTime("直播收视时长"), //时长 收视时长
    playTime("直播次数"); //次数

    private String description;

    LiveIndex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
