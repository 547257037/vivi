package com.tiantian.enums;

import lombok.Getter;

/**
 * @author 付天
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/29 0029下午 6:55
 */
@Getter
public enum SystemMenuStatusEnum {

    SHOW(1, "显示"),
    NOSHOW(2, "不显示");

    private Integer code;

    private String message;

    SystemMenuStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
