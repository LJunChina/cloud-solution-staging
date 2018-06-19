package com.cloud.base.sso.service;

/**
 * token相关api调用
 *
 * @author Jon_China
 * @create 2018/1/12
 */
public interface TokenService {
    /**
     * 检测token是否有效
     * @param tokenId token
     * @return
     */
    String checkLoginToken(String tokenId);

    /**
     * 查询当前登录用户信息
     * @param userId 用户id
     * @return
     */
    String getLoginUserInfo(String userId);

    /**
     * 检查当前登录用户是否拥有权限访问
     * @param userId 当前登录用户id
     * @param appId 当前接入系统id
     * @param uri 当前请求uri
     * @return
     */
    String checkLoginUserPrivilege(String userId,String appId,String uri);
}
