package com.cloud.common.enums;

/**
 * YesOrNo枚举类
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public enum YesOrNoEnum {
    YES("1","是"),
    NO("0","否");
    private String code;
    private String message;

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
    YesOrNoEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
