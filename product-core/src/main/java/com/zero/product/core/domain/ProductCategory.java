package com.zero.product.core.domain;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategory {

    private String category;

    private String name;

    private String description;

    private String tenantId;

    private List<CategoryFeature> features;

    private List<BusiType> busiTypes;

}
