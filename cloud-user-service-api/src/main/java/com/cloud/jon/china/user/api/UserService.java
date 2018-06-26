package com.cloud.jon.china.user.api;


import com.cloud.common.dto.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/test")
public interface UserService {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    Result<String> testGet(@PathVariable(value = "id")Long id);
}
