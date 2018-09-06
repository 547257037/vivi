package com.tiantian.enums;

/**
 * @author liwenlong
 * @Title:
 * @Package
 * @Description:
 * @date 2018/07/22
 */
public enum LookBackIndex {

    lookBackAvgTime("回看次均时长"),
    avgDailySingleFamilyLookBack("日均单户回看次数"),
    programAvgLookBacktime("节目次均收视时长"),
    stbNum("回看用户数"), //到达数
    viewTime("回看收视时长"), //时长 收视时长
    playTime("回看次数"), //次数
    familyAdvgViewTime("户均收视时长");

    private String description;

    LookBackIndex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
