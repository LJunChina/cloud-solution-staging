package com.cloud.jon.china.user.microservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    private String id;

    private String userName;

    private String password;

    private String name;

    private String sex;

    private String status;

    private String orgId;

    private String email;

    private String idCard;

    private String isAdmin;

    private String mobile;

    private String loginToken;

    private Date createAt;

    private Date updateAt;

    private String createBy;

    private String updateBy;

    private String appId;

    private static final long serialVersionUID = 1L;
}