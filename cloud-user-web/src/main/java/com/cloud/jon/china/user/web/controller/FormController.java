package com.cloud.jon.china.user.web.controller;

import com.cloud.common.dto.BaseRespDTO;
import com.cloud.jon.china.user.api.FormService;
import com.cloud.jon.china.user.web.service.FormApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/form1")
public class FormController {

    @Autowired
    private FormApi formApi;

    @GetMapping(value = "/find")
    public BaseRespDTO find(@RequestParam(value = "pageIndex")Integer pageIndex,
                            @RequestParam(value = "pageSize") Integer pageSize){
        return formApi.find(pageIndex,pageSize);
    }
}
