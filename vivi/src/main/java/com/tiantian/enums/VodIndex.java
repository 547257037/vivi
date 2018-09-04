package com.tiantian.enums;

/**
 * @author 张云翔
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/3010:29
 */
public enum VodIndex {
    /**
     * 到达数
     */
    stbNum("直播用户数"),
    /**
     * 时长 收视时长
     */
    viewTime("直播收视时长"),
    /**
     * 次数
     */
    playTime("直播次数"),
    /*
    *转换率
     */
    onversionRate("转换率");
    private String description;

    VodIndex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
