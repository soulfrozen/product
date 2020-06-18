package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductCategoryFeatureEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryFeatureEntityMapper {

    int deleteProductCategoryFeaturesEntityByCategory(String category);

    List<ProductCategoryFeatureEntity> selectProductCategoryFeaturesEntityByCategory(String category);

    int bulkInsertProductFeatureEntity(List<ProductCategoryFeatureEntity> list);

    int insertProductCategoryFeatureEntity(ProductCategoryFeatureEntity entity);
}
