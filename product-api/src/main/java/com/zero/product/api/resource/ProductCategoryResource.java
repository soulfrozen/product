package com.zero.product.api.resource;

import com.zero.common.core.model.CommonResult;
import com.zero.product.core.domain.ProductCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
public interface ProductCategoryResource {

    @GetMapping
    CommonResult<List<ProductCategory>> selectAll();

    @GetMapping("/{category}")
    CommonResult<ProductCategory> selectCategory(@PathVariable("category") String category);
}
