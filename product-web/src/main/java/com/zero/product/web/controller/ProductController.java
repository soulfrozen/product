package com.zero.product.web.controller;

import com.zero.common.core.model.CommonResult;
import com.zero.common.core.page.PageModel;
import com.zero.product.api.resource.ProductResource;
import com.zero.product.core.domain.Product;
import com.zero.product.api.convert.ApiProductMapConverter;
import com.zero.product.api.model.qo.ProductPagingRequest;
import com.zero.product.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class ProductController implements ProductResource {

    private final ProductService productService;

    private final ApiProductMapConverter apiProductMapConverter;

    public ProductController(ProductService productService, ApiProductMapConverter apiProductMapConverter) {
        this.productService = productService;
        this.apiProductMapConverter = apiProductMapConverter;
    }

    @Override
    public CommonResult<PageModel<Product>> list(ProductPagingRequest request) {
        return CommonResult.ok(productService.findAll(request));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        productService.create(product);
        return product;
    }

    @GetMapping("/{productCode}")
    @Override
    public CommonResult<Product> selectProductByProductCode(@PathVariable("productCode") String productCode) {
        return CommonResult.ok(productService.selectProductEntityByProductCode(productCode));
    }

    @PostMapping("/{productCode}/publish")
    public void publishProduct(@PathVariable("productCode") String productCode) {
        productService.updateProductStatus(productCode, Product.ProductStatus.PUBLISHED);
    }

    @PostMapping("/{productCode}/down")
    public void downProduct(@PathVariable("productCode") String productCode) {
        productService.updateProductStatus(productCode, Product.ProductStatus.DOWN);
    }

    @Override
    public CommonResult<Map<String, Object>> adapterProductMapSelectProductByProductCode(@PathVariable("productCode") String productCode) {
        return CommonResult.ok(apiProductMapConverter.from(productService.selectProductEntityByProductCode(productCode)));
    }
}
