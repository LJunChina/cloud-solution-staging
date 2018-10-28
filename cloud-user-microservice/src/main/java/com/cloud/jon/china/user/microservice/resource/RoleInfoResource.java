package com.cloud.jon.china.user.microservice.resource;

import com.cloud.common.dto.Result;
import com.cloud.jon.china.user.api.RoleService;
import com.cloud.jon.china.user.dto.request.RoleInfoRequest;
import com.cloud.jon.china.user.dto.vo.RuleInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RoleInfoResource implements RoleService {

    @Override
    public Result<RuleInfoVO> getRoleInfo(RoleInfoRequest request) {
        log.info("params of getRoleInfo:{}",request);
        return new Result<>();
    }
}
