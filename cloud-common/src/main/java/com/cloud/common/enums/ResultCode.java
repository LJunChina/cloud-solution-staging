package com.cloud.common.enums;

public enum ResultCode {

    OK("0000","处理成功"),
    FAIL("9000","处理失败"),
    ERROR("9999","服务器异常,请稍后再试"),
    PARAMS_NOT_FOUND("8000","缺少参数"),
    USER_NAME_NOT_ALLOW_EMPTY("9010","用户名称不能为空"),
    PASSWORD_NOT_ALLOW_EMPTY("9011","登录密码不能为空"),
    USER_NAME_OR_PASSWORD_ERROR("9012","用户名或密码错误"),
    NO_DATA_FOUND("未查询到任何数据","4000"),
    NO_PRIVILEGE("7000","无相关权限"),
    INVALID_USER("9014","非法用户"),
    INVALID_CODE("9013","验证码错误"),
    INVALID_PARAM("9015","非法参数"),
    LOGIN_EFFICACY("8001","登录失效"),
    NOT_SUPPORT_ENCODE("2222","不支持的编码类型");

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
    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
