package com.cloud.jon.china.gateway.filter;

import com.cloud.common.util.EmptyChecker;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权过滤器
 *
 * @author Jon_China
 * @create 2018/6/29
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterType.PRE.getType();
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("send {} request to {}",request.getMethod(),request.getRequestURI());
        String token = request.getParameter("accessToken");
        if(EmptyChecker.isEmpty(token)){
            log.warn("there is no accessToken");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        log.info("accessToken {} is ok",token);
        return null;
    }

    enum FilterType{

        PRE("pre"),
        ROUTE("route"),
        POST("post"),
        ERROR("error"),
        STATIC("static");

        private String type;

        FilterType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
