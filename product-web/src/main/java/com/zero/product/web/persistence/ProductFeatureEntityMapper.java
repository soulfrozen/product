package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductFeatureEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFeatureEntityMapper {

    int insertProductFeatureEntity(ProductFeatureEntity productFeatureEntity);

    int bulkInsertProductFeatureEntity(List<ProductFeatureEntity> list);

    List<ProductFeatureEntity> selectProductFeatureEntityByProductCode(String productCode);

    int deleteProductFeatureEntityByProductCode(String productCode);
}
