package com.cloud.common.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 请求报文基类
 *
 * @author Jon_China
 * @create 2018/3/14
 */
public class BaseReqDTO implements Serializable {

    private static final long serialVersionUID = 718204564485495427L;

    private int pageIndex;

    private int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
