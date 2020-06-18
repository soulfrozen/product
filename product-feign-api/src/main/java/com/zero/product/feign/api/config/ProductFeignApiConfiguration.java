package com.zero.product.feign.api.config;

import com.zero.product.feign.api.ProductCategoryFeignApi;
import com.zero.product.feign.api.ProductFeignApi;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = {ProductFeignApi.class, ProductCategoryFeignApi.class})
public class ProductFeignApiConfiguration {


}
