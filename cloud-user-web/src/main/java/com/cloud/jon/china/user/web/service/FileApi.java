package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.api.FileService;
import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@FeignClient(name = "CLOUD-USER-MICROSERVICE",configuration = FileApi.MultipartSupportConfig.class)
public interface FileApi extends FileService {



    @Configuration
    class MultipartSupportConfig {

        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

        @Bean
        @Scope("prototype")
        public Feign.Builder feignBuilder(){
            return Feign.builder();
        }
    }
}
