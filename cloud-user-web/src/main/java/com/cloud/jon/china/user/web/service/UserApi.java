package com.cloud.jon.china.user.web.service;

import com.cloud.common.dto.Result;
import com.cloud.jon.china.user.api.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CLOUD-USER-MICROSERVICE",fallback = UserServiceFallBack.class)
public interface UserApi{

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    Result<String> testGet(@PathVariable(value = "id")Long id);
}
