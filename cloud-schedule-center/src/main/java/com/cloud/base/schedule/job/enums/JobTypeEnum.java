package com.cloud.base.schedule.job.enums;

public enum JobTypeEnum {

    REMOTE("00","远程调用"),
    LOCAL("01","本地任务");

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

    JobTypeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
