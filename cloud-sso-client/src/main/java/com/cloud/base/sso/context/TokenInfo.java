package com.cloud.base.sso.context;

import java.io.Serializable;

/**
 * token
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public class TokenInfo implements Serializable {
    private static final long serialVersionUID = 8252838869078177957L;

    private String userId;

    private Long expires;

    private String appName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
