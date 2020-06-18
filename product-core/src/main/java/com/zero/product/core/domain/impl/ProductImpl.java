package com.zero.product.core.domain.impl;

import com.zero.product.core.domain.Feature;
import com.zero.product.core.domain.Product;

import java.util.List;

public class ProductImpl implements Product {

    private String productCode;

    private String productName;

    private String description;

    private String category;

    private ProductStatus status;

    private String tenantId;

    private String busiType;

    private List<Feature> features;

    @Override
    public String getProductCode() {
        return productCode;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public List<Feature> getFeatures() {
        return features;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public ProductStatus getStatus() {
        return status;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }
}
