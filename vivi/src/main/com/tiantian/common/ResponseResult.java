package com.tiantian.common;


import java.util.List;

/**
 * Created by zyx on 2017/6/5.
 */
public class ResponseResult {
    private Object data;
    private boolean success;
    private String errorMessage;
    private int errorCode;
    private PageInfo pageInfo;
    private String messageTip;
    private Object otherData;

    public ResponseResult(Object data, boolean success, String errorMessage, int errorCode) {
        this.data = data;
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static ResponseResult putSuccessData(Object data) {
        return new ResponseResult(data, true, "", 0);
    }
    public static ResponseResult putSuccessData(Object data, Object otherData) {
        ResponseResult responseResult = new ResponseResult(data, true, "", 0);
        responseResult.setOtherData(otherData);
        return responseResult;
    }
    public static ResponseResult putSuccessData(Object data, Object otherData, String messageTip) {
        ResponseResult responseResult = putSuccessData(data);
        responseResult.setMessageTip(messageTip);
        responseResult.setOtherData(otherData);
        return responseResult;
    }

    public static ResponseResult putSuccessMessage(String message) {
        return new ResponseResult(null, true, message, StarvConst.SUCCESS_CODE);
    }

    public static ResponseResult putSuccessMessage() {
        return new ResponseResult(null, true, "success", StarvConst.SUCCESS_CODE);
    }

    public static ResponseResult putPageList(List data, PageInfo pageInfo) {
        return putPageList(data, pageInfo, "");
    }

    public static ResponseResult putPageList(List data, PageInfo pageInfo, String warnMessage) {
        ResponseResult responseResult = new ResponseResult(data, true, warnMessage, StarvConst.SUCCESS_CODE);
        responseResult.setPageInfo(pageInfo);
        return responseResult;
    }


    public static ResponseResult putError(String errorMessage) {
        return new ResponseResult(null, false, errorMessage, StarvConst.CUSTOMS_ERROR_CODE);
    }

    public static ResponseResult putError(String errorMessage, int errorCode) {
        return new ResponseResult(null, false, errorMessage, errorCode);
    }

    public static ResponseResult putError() {
        return new ResponseResult(null, false, "未捕获的异常", StarvConst.UNCHECKED_ERROR_CODE);
    }

    public Object getOtherData() {
        return otherData;
    }

    public void setOtherData(Object otherData) {
        this.otherData = otherData;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageTip() {
        return messageTip;
    }

    public void setMessageTip(String messageTip) {
        this.messageTip = messageTip;
    }
}
