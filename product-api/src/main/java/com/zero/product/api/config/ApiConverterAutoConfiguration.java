package com.zero.product.api.config;

import com.zero.product.api.convert.ApiProductMapConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConverterAutoConfiguration {

    @Bean
    public ApiProductMapConverter apiProductMapConverter() {
        return new ApiProductMapConverter();
    }
}
