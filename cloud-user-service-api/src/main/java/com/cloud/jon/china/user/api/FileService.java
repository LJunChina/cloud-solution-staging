package com.cloud.jon.china.user.api;

import com.cloud.common.dto.BaseRespDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/file")
public interface FileService {

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    BaseRespDTO upload(@RequestParam(value = "code") Integer code,@RequestParam(value = "displayName") String displayName, @RequestPart(value = "file") MultipartFile file);
}
