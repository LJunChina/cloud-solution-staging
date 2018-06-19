package com.cloud.base.sso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * sso客户端url地址配置
 *
 * @author Jon_China
 * @create 2018/1/13
 */
@Component
@ConfigurationProperties(prefix = "sso")
public class UrlConfig {

    private String domain;

    private String appName;

    private String appUrl;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}
