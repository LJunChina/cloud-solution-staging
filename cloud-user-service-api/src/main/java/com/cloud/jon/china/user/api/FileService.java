package com.cloud.jon.china.user.api;

import com.cloud.common.dto.BaseRespDTO;
import com.cloud.jon.china.user.dto.FileRequestDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/file")
public interface FileService {

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    BaseRespDTO upload(@RequestParam(value = "code") Integer code,@RequestParam(value = "displayName") String displayName, @RequestPart(value = "file") MultipartFile file);

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    BaseRespDTO save(@RequestBody FileRequestDto dto);

}
