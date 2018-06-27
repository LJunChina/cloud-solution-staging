package com.cloud.jon.china.user.web.service;

import com.cloud.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/6/26
 */
@Slf4j
@Component
public class UserServiceFallBack implements UserApi {

    @Override
    public Result<String> testGet(Long id) {
        Result<String> result = new Result<>();
        result.setData("降级服务被调用");
        return result;
    }
}
