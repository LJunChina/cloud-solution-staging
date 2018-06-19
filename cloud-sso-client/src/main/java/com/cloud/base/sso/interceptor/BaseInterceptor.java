package com.cloud.base.sso.interceptor;

import com.cloud.base.sso.config.UrlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 拦截器基类
 *
 * @author Jon_China
 * @create 2018/1/12
 */
public abstract class BaseInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Autowired
    private UrlConfig urlConfig;

    protected String redirectUrl;

    protected void init() throws UnsupportedEncodingException{
        redirectUrl = urlConfig.getDomain() + "?redirectUrl=" + URLEncoder.encode(urlConfig.getAppUrl(),"UTF-8") + "&appName=" + urlConfig.getAppName() + "";
    }

    /**
     * 检查token是否有效
     * @param response
     * @param isAjax
     * @param jsonResult
     * @return
     */
    protected void redirect(HttpServletResponse response, boolean isAjax, String jsonResult) throws IOException {
        logger.info("user login already disabled");
        if(isAjax){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResult);
            return;
        }
        response.sendRedirect(redirectUrl);
    }
}
