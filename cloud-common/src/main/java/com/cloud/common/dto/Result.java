package com.cloud.common.dto;

import com.alibaba.fastjson.JSON;
import com.cloud.common.enums.ResultCode;

import java.io.Serializable;

/**
 * 接口返回报文
 *
 * @author Jon_China
 * @create 2018/6/21
 */
public class Result<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 7617209454694318001L;
    private String msg;

    private String code;

    private T data;

    public Result() {
        this(ResultCode.OK);
    }

    public Result(ResultCode resultCode){
        this(resultCode.getMessage(),resultCode.getCode());
    }

    public Result(String msg,String code){
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
