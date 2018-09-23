package com.cloud.jon.china.user.microservice.resource;

import com.cloud.common.dto.BaseRespDTO;
import com.cloud.jon.china.user.dto.FileRequestDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传restAPI
 * @author Jon_China
 * @since 2018年9月23日11:31:01
 */
@Api("文件上传")
@Slf4j
@RestController
@RequestMapping(value = "/file")
public class FileResource {

    @PostMapping(value = "/upload")
    public BaseRespDTO upload(FileRequestDto requestDto, MultipartFile file){
        log.info("params of upload:{},and file name:{}",requestDto,file.getOriginalFilename());
        //File newFile = new File("");
        //file.transferTo();
        return new BaseRespDTO();
    }
}
