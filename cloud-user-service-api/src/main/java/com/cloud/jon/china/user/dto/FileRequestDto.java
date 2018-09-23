package com.cloud.jon.china.user.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class FileRequestDto implements Serializable {
    private static final long serialVersionUID = 8765214500310671547L;

    private Integer code;

    private String displayName;


}
