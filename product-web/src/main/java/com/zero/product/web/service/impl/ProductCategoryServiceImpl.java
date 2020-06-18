package com.zero.product.web.service.impl;

import com.zero.autoconfigure.util.DomainUtil;
import com.zero.common.core.constant.StatusCode;
import com.zero.common.core.page.PageModel;
import com.zero.common.web.util.Shift;
import com.zero.product.web.entity.ProductCategoryBusiTypeEntity;
import com.zero.product.web.entity.ProductCategoryEntity;
import com.zero.product.web.entity.ProductCategoryFeatureEntity;
import com.zero.product.web.persistence.ProductCategoryBusiTypeEntityMapper;
import com.zero.product.web.persistence.ProductCategoryEntityMapper;
import com.zero.product.web.persistence.ProductCategoryFeatureEntityMapper;
import com.zero.product.web.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryEntityMapper productCategoryEntityMapper;

    private final ProductCategoryFeatureEntityMapper productCategoryFeatureEntityMapper;

    private final ProductCategoryBusiTypeEntityMapper productCategoryBusiTypeEntityMapper;

    public ProductCategoryServiceImpl(ProductCategoryEntityMapper productCategoryEntityMapper, ProductCategoryFeatureEntityMapper productCategoryFeatureEntityMapper, ProductCategoryBusiTypeEntityMapper productCategoryBusiTypeEntityMapper) {
        this.productCategoryEntityMapper = productCategoryEntityMapper;
        this.productCategoryFeatureEntityMapper = productCategoryFeatureEntityMapper;
        this.productCategoryBusiTypeEntityMapper = productCategoryBusiTypeEntityMapper;
    }


    @Transactional
    @Override
    public ProductCategoryEntity createCategory(ProductCategoryEntity productCategoryEntity) {

        ProductCategoryEntity oriCategory = selectCategory(productCategoryEntity.getCategory());

        if (oriCategory != null) {
            Shift.fatal(StatusCode.INVALID_PARAMS_VALIDATE, "category已存在 : " + productCategoryEntity.getCategory());
        }

        DomainUtil.afterProperties(productCategoryEntity);
        List<ProductCategoryFeatureEntity> features = productCategoryEntity.getFeatures();
        for (ProductCategoryFeatureEntity feature : features) {
            feature.setCategory(productCategoryEntity.getCategory());
            DomainUtil.afterProperties(feature);
        }
        productCategoryEntity.getBusiTypes().forEach(a -> a.setCategory(productCategoryEntity.getCategory()));

        productCategoryEntityMapper.insertProductCategoryEntity(productCategoryEntity);
        productCategoryFeatureEntityMapper.bulkInsertProductFeatureEntity(features);
        productCategoryBusiTypeEntityMapper.bulkInsertProductBusiTypeEntity(productCategoryEntity.getBusiTypes());
        return productCategoryEntity;
    }

    @Override
    public ProductCategoryEntity selectCategory(String category) {
        ProductCategoryEntity productCategoryEntity = productCategoryEntityMapper.selectProductCategoryEntityByCategory(category);
        if (productCategoryEntity != null) {
            productCategoryEntity.setFeatures(productCategoryFeatureEntityMapper.selectProductCategoryFeaturesEntityByCategory(category));

            productCategoryEntity.setBusiTypes(productCategoryBusiTypeEntityMapper.selectProductCategoryBusiTypesEntityByCategory(category));
        }
        return productCategoryEntity;
    }

    @Override
    public void addBusiType(String category, ProductCategoryBusiTypeEntity busiTypeEntity) {
        ProductCategoryEntity oriCategory = selectCategory(category);

        if (oriCategory == null) {
            Shift.fatal(StatusCode.INVALID_PARAMS_VALIDATE, "category不存在 : " + category);
        }
        busiTypeEntity.setCategory(category);

        productCategoryBusiTypeEntityMapper.insertProductCategoryBusiTypeEntity(busiTypeEntity);

    }

    @Override
    public List<ProductCategoryEntity> selectAll() {
        List<ProductCategoryEntity> productCategoryEntities = productCategoryEntityMapper.selectAll();
        productCategoryEntities.forEach(a -> {
            a.setFeatures(productCategoryFeatureEntityMapper.selectProductCategoryFeaturesEntityByCategory(a.getCategory()));

            a.setBusiTypes(productCategoryBusiTypeEntityMapper.selectProductCategoryBusiTypesEntityByCategory(a.getCategory()));

        });
        return productCategoryEntities;
    }
}
