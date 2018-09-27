package com.cloud.common.mq;

import lombok.Data;

import java.io.Serializable;

@Data
public class SortBean implements Serializable {
    private static final long serialVersionUID = -4781125060517746762L;

    private Long userId;

    private Integer sort;

    private Integer realSort;
}
