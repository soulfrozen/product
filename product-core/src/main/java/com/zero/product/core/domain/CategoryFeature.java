package com.zero.product.core.domain;

import lombok.Data;

@Data
public class CategoryFeature {

    private String name;

    private String description;

    private String valueType;

    private String dictCode;

    private String clazz;

    private String checkRule;

    // 0 可选  1 必选
    private String optional;
}
