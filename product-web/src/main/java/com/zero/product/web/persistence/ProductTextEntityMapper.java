package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductTextEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductTextEntityMapper {

    int insertProductTextEntity(ProductTextEntity entity);

    int deleteProductTextByProductCodeAndTextId(@Param("productCode") String productCode, @Param("textId") String textId);

    int bulkInsertProductTextEntity(List<ProductTextEntity> list);

    ProductTextEntity selectProductTextEntityByProductCodeAndTextId(@Param("productCode") String productCode, @Param("textId") String textId);

    List<ProductTextEntity> selectProductTextEntityByProductCode(String productCode);
}
