package com.cloud.jon.china.gateway;

import com.cloud.common.util.EmptyChecker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Jon_China
 * @create 2018/6/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudServiceGatewayApplication {
    public static void main(String[] args) {
        if(EmptyChecker.isEmpty(System.getProperty("spring.profiles.active"))){
            System.setProperty("spring.profiles.active","dev");
        }
        SpringApplication.run(CloudServiceGatewayApplication.class, args);
    }
}
