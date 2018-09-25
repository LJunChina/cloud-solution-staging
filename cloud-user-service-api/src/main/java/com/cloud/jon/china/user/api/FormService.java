package com.cloud.jon.china.user.api;

import com.cloud.common.dto.BaseRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/form")
public interface FormService {

    @GetMapping(value = "/find")
    BaseRespDTO find(@RequestParam(value = "pageIndex")Integer pageIndex,
                            @RequestParam(value = "pageSize") Integer pageSize);
}
