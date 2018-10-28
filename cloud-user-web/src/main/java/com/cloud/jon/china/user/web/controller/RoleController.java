package com.cloud.jon.china.user.web.controller;

import com.cloud.common.dto.Result;
import com.cloud.jon.china.user.dto.request.RoleInfoRequest;
import com.cloud.jon.china.user.dto.vo.RuleInfoVO;
import com.cloud.jon.china.user.web.service.RoleInfoApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleInfoApi roleInfoApi;

    @GetMapping(value = "/get")
    public Result<RuleInfoVO> getRuleInfo(RoleInfoRequest request){
      log.info("params of getRuleInfo:{}",request);
        Result<RuleInfoVO> result = this.roleInfoApi.getRoleInfo(request);
        log.info("result of getRuleInfo:{}",result);
        return result;
    }
}
