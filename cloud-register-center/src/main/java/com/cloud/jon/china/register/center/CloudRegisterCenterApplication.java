package com.cloud.jon.china.register.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudRegisterCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudRegisterCenterApplication.class, args);
	}
}
