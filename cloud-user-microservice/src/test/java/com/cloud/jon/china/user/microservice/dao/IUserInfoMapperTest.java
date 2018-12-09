package com.cloud.jon.china.user.microservice.dao;

import com.cloud.common.enums.YesOrNoEnum;
import com.cloud.common.model.UserInfo;
import com.cloud.jon.china.user.microservice.UserMicroServiceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class IUserInfoMapperTest extends UserMicroServiceApplicationTests {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setEmail("test");
        userInfo.setName("test");
        userInfo.setAppId(UUID.randomUUID().toString());
        userInfo.setIsAdmin(YesOrNoEnum.YES.getCode());
        userInfo.setIdCard("123");
        userInfo.setMobile("1234556");
        userInfo.setSex("1");
        userInfo.setStatus("00");
        userInfo.setCreateAt(new Date());
        userInfo.setCreateBy("system");
        this.userInfoMapper.insert(userInfo);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Assert.assertNotNull(this.userInfoMapper.selectByPrimaryKey("342dc4fd-ddeb-42ad-87b8-a53ab1ab45ea" ));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void testDelete(){
        int i = userInfoMapper.testDelete("18a440b1-0a77-11e8-a420-525400728206");
        assertEquals(1,i);
    }

}