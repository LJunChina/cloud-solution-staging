package com.cloud.jon.china.user.microservice.dao;

import com.cloud.jon.china.user.microservice.UserMicroServiceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class IUserInfoMapperTest extends UserMicroServiceApplicationTests {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
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

}