package com.cloud.common.exception;

public class RSAEncryptException extends RuntimeException {

    public RSAEncryptException() {
        super();
    }

    public RSAEncryptException(String message) {
        super(message);
    }

    public RSAEncryptException(String message, Throwable cause) {
        super(message, cause);
    }

    protected RSAEncryptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RSAEncryptException(Throwable cause) {
        super(cause);
    }
}
