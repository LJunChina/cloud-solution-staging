package com.cloud.jon.china.user.microservice;

import com.cloud.common.util.EmptyChecker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringCloudApplication
@EnableTransactionManagement
@MapperScan(value = "com.cloud.jon.china.user.microservice.dao")
public class UserMicroServiceApplication {

	public static void main(String[] args) {
	    if(EmptyChecker.isEmpty(System.getProperty("spring.profiles.active"))){
            System.setProperty("spring.profiles.active","dev");
        }
		SpringApplication.run(UserMicroServiceApplication.class, args);
	}
}
