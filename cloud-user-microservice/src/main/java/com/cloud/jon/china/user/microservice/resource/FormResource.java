package com.cloud.jon.china.user.microservice.resource;

import com.cloud.common.dto.BaseRespDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api("表单测试")
@Slf4j
@RestController
@RequestMapping(value = "/form")
public class FormResource {

    @GetMapping(value = "/find")
    public BaseRespDTO find(@RequestParam(value = "pageIndex")Integer pageIndex,@RequestParam(value = "pageSize") Integer pageSize){
        log.info("params of find,pageIndex:{},pageSize:{}",pageIndex,pageSize);
        return new BaseRespDTO();
    }
}
