package com.cloud.base.sso.util;


/**
 * 各服务接口
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public final class Constant {
    /**用户服务*/
    private static final String USER_SERVICE = "http://user-microservice";
    /**检测token是否有效*/
    public static final String CHECK_TOKEN = USER_SERVICE + "/token/check-token/{1}";
    /**根据用户id查询用户信息*/
    public static final String GET_USER_INFO_BY_ID = USER_SERVICE + "/get-user-detail/{1}";
    /**获取用户权限信息*/
    public static final String GET_USER_PRIVILEGE = USER_SERVICE + "/auth/check-privilege?userId={userId}&appId={appId}&uri={uri}";
}