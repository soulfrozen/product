package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryEntityMapper {


    int insertProductCategoryEntity(ProductCategoryEntity productEntity);

    ProductCategoryEntity selectProductCategoryEntityByCategory(String category);

    List<ProductCategoryEntity> selectAll();

}
