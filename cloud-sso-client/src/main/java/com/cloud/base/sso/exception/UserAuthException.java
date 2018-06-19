package com.cloud.base.sso.exception;

/**
 * 用户登录异常
 *
 * @author Jon_China
 * @create 2017/11/17
 */
public class UserAuthException extends RuntimeException {
    public UserAuthException() {
        super();
    }

    public UserAuthException(String message) {
        super(message);
    }

    public UserAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAuthException(Throwable cause) {
        super(cause);
    }

}
