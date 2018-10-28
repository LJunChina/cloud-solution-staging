package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.api.RoleService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "CLOUD-USER-MICROSERVICE")
public interface RoleInfoApi extends RoleService {
}
