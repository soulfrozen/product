package com.zero.product.web.model;

import cn.hutool.core.bean.BeanUtil;
import com.zero.product.core.convert.ListConverter;
import com.zero.product.core.convert.ModelConverter;
import com.zero.product.core.domain.Product;
import com.zero.product.web.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityProductConverter extends ListConverter<Product, ProductEntity> implements ModelConverter<Product, ProductEntity> {

    @Override
    public ProductEntity from(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtil.copyProperties(product, productEntity);
        return productEntity;
    }
}
