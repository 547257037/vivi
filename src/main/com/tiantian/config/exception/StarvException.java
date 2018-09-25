package com.tiantian.config.exception;

import com.tiantian.common.TianTianConst;

/**
 *
 *  标准的异常应该实现约定俗成的四个构造器...
 *
 *
 * @author zyx
 * @date 2017/6/26
 */
public class StarvException extends RuntimeException {

    private int errorCode = TianTianConst.CUSTOMS_ERROR_CODE;

    public StarvException(String message) {
        super(message);
    }

    public StarvException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
