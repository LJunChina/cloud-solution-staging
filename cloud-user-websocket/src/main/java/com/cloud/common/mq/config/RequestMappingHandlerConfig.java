package com.cloud.common.mq.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
public class RequestMappingHandlerConfig extends RequestMappingHandlerMapping {

    @Override
    public Map<RequestMappingInfo, HandlerMethod> getHandlerMethods() {
        return super.getHandlerMethods();
    }
}
