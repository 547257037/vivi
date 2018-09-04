package com.tiantian.enums;

/**
 * @author 董建
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/3010:07
 */
public enum FlatForm {
    HW("华为"),
    ZTE("中兴");

    private String description;


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    FlatForm(String description) {
        this.description = description;
    }




    public String getName() {
        return this.name();
    }

    /**
     * 根据运营商代码获取名字
     * <p>
     * 比如：
     * "HW" --> "华为"
     * "ZTE" --> "中兴"
     *
     * @param operatorName
     * @return
     */
    public static String getPrettyName(String operatorName) {
        for (FlatForm flatForm : values()) {
            if (flatForm.name().equals(operatorName)) {
                return flatForm.getDescription();
            }
        }
        return null;
    }

    public static FlatForm[] getAllOperator() {
        return new FlatForm[]{FlatForm.HW, FlatForm.ZTE};
    }

}
