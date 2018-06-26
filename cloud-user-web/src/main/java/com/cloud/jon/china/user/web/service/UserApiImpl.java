package com.cloud.jon.china.user.web.service;

import com.cloud.common.dto.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jon_China
 * @create 2018/6/26
 */
@Slf4j
public class UserApiImpl implements UserApi {

    @Override
    public Result<String> testGet(Long id) {
        Result<String> result = new Result<>();
        result.setData("hello");
        log.info("result of fallback:{}",result);
        return result;
    }
}
