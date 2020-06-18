package com.zero.product.web.entity;

import lombok.Data;

@Data
public class SysDictItemEntity {

    private String dictCode;

    private String code;

    private String label;

    private String description;

    private Integer sort;
}
