package com.cloud.jon.china.user.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInfoRequest implements Serializable {
    private static final long serialVersionUID = 7753589177100686877L;

    private Long id;

    private String roleName;

    private String roleGroup;


}
