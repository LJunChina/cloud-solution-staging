package com.cloud.jon.china.user.web.service;

import com.cloud.jon.china.user.dto.FileRequestDto;
import com.cloud.jon.china.user.web.UserWebApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

@Slf4j
public class FileApiTest extends UserWebApplicationTests {

    @Autowired
    private FileApi fileApi;

    @Test
    public void testUpload(){
        File file = new File("D:\\upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        FileRequestDto dto = new FileRequestDto();
        dto.setCode(231);
        dto.setDisplayName("4242");
        log.info(fileApi.upload(132,"342",multi).toString());
    }


}