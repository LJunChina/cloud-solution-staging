package com.cloud.job.china.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.job.china.config.RequestMappingHandlerConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * mvc接口映射
 * @author Jon_China
 * @version 1.0
 * @since 2018年10月24日20:20:34
 */
@RestController
@RequestMapping(value = "/handler")
public class HandlerMappingController {

    @Autowired
    private RequestMappingHandlerConfig requestMappingHandlerConfig;

    @GetMapping(value = "/mapping1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String mapping(@RequestParam(value = "a",required = false) String a,
                          @RequestParam(value = "b",required = false)String b){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = this.requestMappingHandlerConfig.getHandlerMethods();
        Set<RequestMappingInfo> mappingInfos = handlerMethods.keySet();
        List<Api> apiList = new ArrayList<>();
        mappingInfos.forEach(m ->{
            Api currentApi = new Api();
            currentApi.setUrl(m.getPatternsCondition().getPatterns().stream().findFirst().orElse(""));
            currentApi.setMethods(m.getMethodsCondition().getMethods().stream().map(RequestMethod::toString).collect(Collectors.toSet()));
            currentApi.setProduce(m.getProducesCondition().isEmpty() ? MediaType.APPLICATION_JSON_UTF8.toString() : m.getProducesCondition().getProducibleMediaTypes().stream().findFirst().orElse(MediaType.APPLICATION_JSON_UTF8).toString());
            apiList.add(currentApi);
        });
        return JSONObject.toJSONString(apiList);
    }

    @Data
    class Api implements Serializable {

        private static final long serialVersionUID = -132303862818612145L;
        private String url;

        private Set<String> methods = Collections.singleton(RequestMethod.GET.name());

        private String produce;

    }

    @PostMapping(value = "/mapping2")
    public String mapping1(){
        return "";
    }

    @RequestMapping(value = "/mapping3")
    public String mapping2(){
        return "";
    }
}
