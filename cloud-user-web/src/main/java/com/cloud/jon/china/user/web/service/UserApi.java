package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.api.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cloud-user-microservice",fallback = UserApiImpl.class)
public interface UserApi extends UserService {
}
