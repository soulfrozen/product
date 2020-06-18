package com.zero.product.web.service;

import com.zero.common.core.page.PageModel;
import com.zero.product.core.domain.Product;
import com.zero.product.api.model.qo.ProductPagingRequest;

public interface ProductService {

    void create(Product product);

    Product selectProductEntityByProductCode(String productCode);

    PageModel<Product> findAll(ProductPagingRequest request);

    void updateProductStatus(String productCode, Product.ProductStatus published);
}
