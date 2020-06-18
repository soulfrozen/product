package com.zero.product.core.domain;



public abstract class AbstractFeature<T> implements Feature<T> {

    private String productCode;

    private String name;

    @Override
    public String getProductCode() {
        return productCode;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setName(String name) {
        this.name = name;
    }
}
