package com.cloud.jon.china.user.api;

import com.cloud.common.dto.Result;
import com.cloud.jon.china.user.dto.request.RoleInfoRequest;
import com.cloud.jon.china.user.dto.vo.RuleInfoVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/role")
public interface RoleService {


    @GetMapping(value = "/get",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<RuleInfoVO> getRoleInfo(@RequestBody RoleInfoRequest request);

}
