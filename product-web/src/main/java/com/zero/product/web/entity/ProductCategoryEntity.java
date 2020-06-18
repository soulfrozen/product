package com.zero.product.web.entity;

import com.zero.common.core.domain.BasicEntity;
import com.zero.product.core.domain.Product;
import com.zero.product.core.domain.TenantScope;

import java.util.List;

public class ProductCategoryEntity extends BasicEntity<String> implements TenantScope {

    private String category;

    private String name;

    private String description;

    private String tenantId;

    private List<ProductCategoryFeatureEntity> features;

    private List<ProductCategoryBusiTypeEntity> busiTypes;

    @Override
    public String getTenantId() {
        return tenantId;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<ProductCategoryFeatureEntity> getFeatures() {
        return features;
    }

    public void setFeatures(List<ProductCategoryFeatureEntity> features) {
        this.features = features;
    }

    public List<ProductCategoryBusiTypeEntity> getBusiTypes() {
        return busiTypes;
    }

    public void setBusiTypes(List<ProductCategoryBusiTypeEntity> busiTypes) {
        this.busiTypes = busiTypes;
    }
}
