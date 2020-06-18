package com.zero.product.web.service;

import com.zero.product.web.entity.ProductCategoryBusiTypeEntity;
import com.zero.product.web.entity.ProductCategoryEntity;

import java.util.List;

public interface ProductCategoryService {

    ProductCategoryEntity createCategory(ProductCategoryEntity productCategoryEntity);

    ProductCategoryEntity selectCategory(String category);

    void addBusiType(String category, ProductCategoryBusiTypeEntity busiTypeEntity);

    List<ProductCategoryEntity> selectAll();
}
