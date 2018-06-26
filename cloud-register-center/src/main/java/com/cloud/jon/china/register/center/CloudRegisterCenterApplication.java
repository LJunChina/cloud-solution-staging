package com.cloud.jon.china.register.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Objects;

@EnableEurekaServer
@SpringBootApplication
public class CloudRegisterCenterApplication {

	public static void main(String[] args) {
		if(Objects.isNull(System.getProperty("spring.profiles.active"))){
			System.setProperty("spring.profiles.active","dev");
		}
		SpringApplication.run(CloudRegisterCenterApplication.class, args);
	}
}
