package com.zero.product.feign.api;

import com.zero.product.api.resource.ProductCategoryResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "product-web")
public interface ProductCategoryFeignApi extends ProductCategoryResource {
}
