package com.zero.product.api.config;

import com.fasterxml.jackson.databind.Module;
import com.zero.product.api.listener.JsonUtilCustomerContextListener;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JsonUtilCustomerConfiguration {

    @Bean
    public JsonUtilCustomerContextListener jsonUtilCustomerContextListener(ObjectProvider<List<Module>> provider) {
        return new JsonUtilCustomerContextListener(provider.getIfAvailable());
    }
}
