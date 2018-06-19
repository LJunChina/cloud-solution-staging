package com.cloud.base.sso.context;

import java.io.Serializable;

/**
 * 当前登录用户信息
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -5541182616476158902L;

    private String userId;

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
