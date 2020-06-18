package com.zero.product.core.domain;

import java.util.List;

public interface Product extends TenantScope {

    String getProductCode();

    String getProductName();

    String getDescription();

    String getCategory();

    String getBusiType();

    List<Feature> getFeatures();

    ProductStatus getStatus();

    enum ProductStatus {
        CREATE, PUBLISHED, DOWN;
    }
}
