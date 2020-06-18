package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductCategoryBusiTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryBusiTypeEntityMapper {

    int insertProductCategoryBusiTypeEntity(ProductCategoryBusiTypeEntity entity);

    List<ProductCategoryBusiTypeEntity> selectProductCategoryBusiTypesEntityByCategory(String category);

    int bulkInsertProductBusiTypeEntity(List<ProductCategoryBusiTypeEntity> list);

    int deleteProductCategoryBusiTypesEntityByCategory(String category);
}
