package com.cloud.jon.china.user.microservice.resource;

import com.cloud.common.dto.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author Jon_China
 * @create 2018/6/21
 */
@Api(value = "测试页面")
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestResource {



    @RequestMapping(value = "/{id}")
    @ApiOperation(value = "获取测试详细信息",notes = "测试详情查询",httpMethod = "GET")
    @ApiResponse(message = "[{}]",code = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "测试编号",required = true,dataType = "java.lang.Long",paramType = "java.lang.Long" )
    })
    public Result<?> testGetRequest(@PathVariable(value = "id") Long id){
        log.info("params of testGetRequest:{}",id);
        Result result = new Result();
        log.info("result of testGetRequest:{}",result);
        return result;
    }

}
