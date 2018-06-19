package com.cloud.base.sso.service.impl;

import com.cloud.base.sso.service.TokenService;
import com.cloud.base.sso.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * token相关api调用
 *
 * @author Jon_China
 * @create 2018/1/12
 */
@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 检测token是否有效
     *
     * @param tokenId token
     * @return
     */
    @Override
    public String checkLoginToken(String tokenId) {
        return this.restTemplate.getForEntity(Constant.CHECK_TOKEN,String.class,tokenId).getBody();
    }

    /**
     * 查询当前登录用户信息
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public String getLoginUserInfo(String userId) {
        return this.restTemplate.getForEntity(Constant.GET_USER_INFO_BY_ID,String.class,userId).getBody();
    }

    /**
     * 检查当前登录用户是否拥有权限访问
     *
     * @param userId 当前登录用户id
     * @param appId  当前接入系统id
     * @param uri    当前请求uri
     * @return
     */
    @Override
    public String checkLoginUserPrivilege(String userId, String appId, String uri) {
        Map<String,String> params = new HashMap<>();
        params.put("userId",userId);
        params.put("appId","1");
        params.put("uri",uri);
        return this.restTemplate.getForEntity(Constant.GET_USER_PRIVILEGE,String.class,params).getBody();
    }
}
