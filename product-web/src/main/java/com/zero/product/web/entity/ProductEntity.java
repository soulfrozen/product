package com.zero.product.web.entity;

import com.zero.common.core.domain.BasicEntity;
import com.zero.product.core.domain.Feature;
import com.zero.product.core.domain.Product;
import com.zero.product.core.domain.TenantScope;

import java.util.List;

public class ProductEntity extends BasicEntity<String> implements TenantScope {


    private String productCode;

    private String productName;

    private String description;

    private String category;

    private Product.ProductStatus status;

    private String busiType;

    private String tenantId;

    @Override
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Product.ProductStatus getStatus() {
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

    public void setStatus(Product.ProductStatus status) {
        this.status = status;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getBusiType() {
        return busiType;
    }
}
