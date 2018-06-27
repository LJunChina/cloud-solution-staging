package com.cloud.jon.china.user.web;

import com.cloud.common.util.EmptyChecker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
public class UserWebApplication {

	public static void main(String[] args) {
        if(EmptyChecker.isEmpty(System.getProperty("spring.profiles.active"))){
            System.setProperty("spring.profiles.active","dev");
        }
		SpringApplication.run(UserWebApplication.class, args);
	}
}
