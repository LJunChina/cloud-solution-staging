package com.cloud.jon.china.user.dto.vo;

import com.cloud.common.model.UserInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RuleInfoVO implements Serializable {
    private static final long serialVersionUID = 9003306489701995965L;

    private Long id;

    private String roleName;

    private List<UserInfo> userInfoList;
}
