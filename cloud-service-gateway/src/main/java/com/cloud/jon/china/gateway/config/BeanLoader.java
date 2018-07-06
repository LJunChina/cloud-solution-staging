package com.cloud.jon.china.gateway.config;

import com.cloud.jon.china.gateway.filter.AccessFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean加载配置
 *
 * @author Jon_China
 * @create 2018/6/29
 */
@Configuration
public class BeanLoader {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    /**
     * zuul路由规则配置
     * @return
     */
    /*@Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
    }*/
}
