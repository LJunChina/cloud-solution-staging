package com.cloud.jon.china.user.web.controller;

import com.cloud.common.dto.BaseRespDTO;
import com.cloud.jon.china.user.api.FileService;
import com.cloud.jon.china.user.dto.FileRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/file1")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    BaseRespDTO upload(@RequestParam(value = "code") Integer code, @RequestParam(value = "displayName") String displayName, @RequestPart(value = "file") MultipartFile file){
        return this.fileService.upload(code,displayName,file);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    BaseRespDTO save(@RequestBody FileRequestDto dto){
        return this.fileService.save(dto);
    }
}
