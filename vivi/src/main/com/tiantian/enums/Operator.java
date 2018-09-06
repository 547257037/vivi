package com.tiantian.enums;

/**
 * @author 董建
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/3010:01
 */
public enum Operator {

    DX("电信"),
    YD("移动"),
    LT("联通");


    private String description;


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    Operator(String description) {
        this.description = description;
    }




    public String getName() {
        return this.name();
    }

    /**
     * 根据运营商代码获取名字
     * <p>
     * 比如：
     * "DX" --> "电信"
     * "LT" --> "联通"
     * "YD" --> "移动"
     *
     * @param operatorName
     * @return
     */
    public static String getPrettyName(String operatorName) {
        for (Operator operator : values()) {
            if (operator.name().equals(operatorName)) {
                return operator.getDescription();
            }
        }
        return null;
    }

    public static Operator[] getAllOperator() {
        return new Operator[]{Operator.YD, Operator.DX, Operator.LT};
    }

}
