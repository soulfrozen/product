package com.zero.product.api.resource;


import com.zero.common.core.model.CommonResult;
import com.zero.common.core.page.PageModel;
import com.zero.product.api.model.qo.ProductPagingRequest;
import com.zero.product.core.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/products")
public interface ProductResource {

    @GetMapping
    CommonResult<PageModel<Product>> list(ProductPagingRequest request);

    @GetMapping("/{productCode}")
    CommonResult<Product> selectProductByProductCode(@PathVariable("productCode") String productCode);

    @GetMapping("/adapter/map/{productCode}")
    CommonResult<Map<String, Object>> adapterProductMapSelectProductByProductCode(@PathVariable("productCode") String productCode);

}
