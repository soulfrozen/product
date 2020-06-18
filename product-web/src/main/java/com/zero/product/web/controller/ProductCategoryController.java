package com.zero.product.web.controller;

import com.zero.common.core.model.CommonResult;
import com.zero.product.api.resource.ProductCategoryResource;
import com.zero.product.core.domain.ProductCategory;
import com.zero.product.web.entity.ProductCategoryBusiTypeEntity;
import com.zero.product.web.entity.ProductCategoryEntity;
import com.zero.product.web.model.ProductCategoryConverter;
import com.zero.product.web.service.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController implements ProductCategoryResource {

    private final ProductCategoryService productCategoryService;

    private final ProductCategoryConverter productCategoryConverter;

    public ProductCategoryController(ProductCategoryService productCategoryService, ProductCategoryConverter productCategoryConverter) {
        this.productCategoryService = productCategoryService;
        this.productCategoryConverter = productCategoryConverter;
    }

    @Override
    public CommonResult<List<ProductCategory>> selectAll() {
        return CommonResult.ok(productCategoryConverter.from(productCategoryService.selectAll()));
    }

    @Override
    public CommonResult<ProductCategory> selectCategory(@PathVariable("category") String category) {

        return CommonResult.ok(productCategoryConverter.from(productCategoryService.selectCategory(category)));
    }

    @PostMapping
    public ProductCategoryEntity createCategory(@RequestBody ProductCategoryEntity productCategoryEntity) {

        // TODO check
        assert productCategoryEntity.getFeatures() != null;
        return productCategoryService.createCategory(productCategoryEntity);
    }

    @PostMapping("/{category}/busiTypes")
    public void addCategoryBusiType(@PathVariable("category") String category, @RequestBody ProductCategoryBusiTypeEntity busiTypeEntity) {
        productCategoryService.addBusiType(category, busiTypeEntity);
    }
}
