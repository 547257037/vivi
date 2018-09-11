package com.tiantian.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by zyx on 2017/7/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PageInfo {

    private int page = 1;

    private int pageMax = 20;

    private long total = 0;

    public int getIndex() {
        return (page - 1) * pageMax;
    }

    public boolean isFirstPage(){
        return page == 1;
    }
}
