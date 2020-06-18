package com.zero.product.web.model;

import cn.hutool.core.bean.BeanUtil;
import com.zero.product.core.convert.ListConverter;
import com.zero.product.core.convert.ModelConverter;
import com.zero.product.core.domain.BusiType;
import com.zero.product.core.domain.CategoryFeature;
import com.zero.product.core.domain.ProductCategory;
import com.zero.product.web.entity.ProductCategoryEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoryConverter extends ListConverter<ProductCategoryEntity, ProductCategory> implements ModelConverter<ProductCategoryEntity, ProductCategory> {
    @Override
    public ProductCategory from(ProductCategoryEntity productCategoryEntity) {
        ProductCategory productCategory = new ProductCategory();
        BeanUtil.copyProperties(productCategoryEntity, productCategory);
        if (!CollectionUtils.isEmpty(productCategoryEntity.getBusiTypes())) {
            List<BusiType> busiTypes = productCategoryEntity.getBusiTypes().stream().map(a -> {
                BusiType busiType = new BusiType();
                BeanUtil.copyProperties(a, busiType);
                return busiType;
            }).collect(Collectors.toList());
            productCategory.setBusiTypes(busiTypes);
        }

        if (!CollectionUtils.isEmpty(productCategoryEntity.getFeatures())) {
            List<CategoryFeature> features = productCategoryEntity.getFeatures().stream().map(a -> {
                CategoryFeature categoryFeature = new CategoryFeature();
                BeanUtil.copyProperties(a, categoryFeature);
                return categoryFeature;
            }).collect(Collectors.toList());
            productCategory.setFeatures(features);
        }

        return productCategory;
    }
}
