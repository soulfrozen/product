package com.zero.product.web.persistence;

import com.zero.product.web.entity.ProductEntity;
import com.zero.product.api.model.qo.ProductPagingRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductEntityMapper {


    int insertProductEntity(ProductEntity productEntity);

    ProductEntity selectProductEntityByProductCode(String productCode);

    List<ProductEntity> selectAll(ProductPagingRequest request);

    void updateProductStatus(@Param("productCode") String productCode);
}
