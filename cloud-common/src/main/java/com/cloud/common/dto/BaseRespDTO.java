package com.cloud.common.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cloud.common.enums.ResultCode;

import java.io.Serializable;

public class BaseRespDTO implements Serializable {
    private static final long serialVersionUID = -7964635136197468217L;

    private Serializable data;

    private String code;

    private String message;


    public BaseRespDTO() {
        this(ResultCode.OK);
    }

    public BaseRespDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public BaseRespDTO(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
    }
}
