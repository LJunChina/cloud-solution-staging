package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.api.FileService;
import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@FeignClient(name = "CLOUD-USER-MICROSERVICE",configuration = FileApi.MultipartSupportConfig.class)
public interface FileApi extends FileService {



    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }

        @Bean
        @Scope("prototype")
        public Feign.Builder feignBuilder(){
            return Feign.builder();
        }
    }
}
