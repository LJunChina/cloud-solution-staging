package com.cloud.jon.china.user.web.controller;

import com.cloud.common.dto.Result;
import com.cloud.jon.china.user.web.service.UserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author Jon_China
 * @create 2018/6/24
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class TestController {

    @Autowired
    private UserApi userApi;

    @GetMapping(value = "/{id}")
    //@HystrixCommand(fallbackMethod = "helloFallBack",commandKey = "helloKey")
    public Result testResource(@PathVariable(value = "id")Long id){
        log.info("params of testResource:{}",id);
        Result result = this.userApi.testGet(id);
        log.info("result of {}",result);
        return result;
    }

    public Result helloFallBack(Long id){
        Result<String> result = new Result<>();
        result.setData("你特么终于出来了");
        return result;
    }
}
