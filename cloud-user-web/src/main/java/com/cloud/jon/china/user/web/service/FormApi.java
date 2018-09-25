package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.api.FormService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "CLOUD-USER-MICROSERVICE")
public interface FormApi extends FormService {
}
