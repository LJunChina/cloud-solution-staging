package com.cloud.base.sso.filter;

import com.cloud.base.sso.config.UrlConfig;
import com.cloud.common.util.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 过滤器基类
 *
 * @author Jon_China
 * @create 2018/1/13
 */
public abstract class BaseFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(BaseFilter.class);

    @Autowired
    private UrlConfig urlConfig;

    protected String redirectUrl;

    protected Set<String> excludeUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludeUrlStr = filterConfig.getInitParameter("excludeUrl");
        if(EmptyChecker.notEmpty(excludeUrlStr)){
            excludeUrl = new HashSet<>(Arrays.asList(excludeUrlStr.split(",")));
        }
        try {
            redirectUrl = urlConfig.getDomain() + "?redirectUrl=" + URLEncoder.encode(urlConfig.getAppUrl(),"UTF-8") + "&appName=" + urlConfig.getAppName() + "";
        }catch (UnsupportedEncodingException e){
            logger.error("encode not supported");
        }
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
