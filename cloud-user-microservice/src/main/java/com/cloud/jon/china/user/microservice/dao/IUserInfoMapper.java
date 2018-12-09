package com.cloud.jon.china.user.microservice.dao;

import com.cloud.common.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository(value = "userInfoMapper")
public interface IUserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int testDelete(String id);

    Date queryLastDay();
}