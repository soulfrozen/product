package com.zero.product.feign.api;

import com.zero.product.api.resource.ProductResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "product-web")
public interface ProductFeignApi extends ProductResource {
}
