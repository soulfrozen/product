package com.zero.product.api.config;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zero.product.api.share.FeatureMixin;
import com.zero.product.core.domain.Feature;
import com.zero.product.core.domain.Product;
import com.zero.product.core.domain.impl.*;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfigureBefore({JacksonAutoConfiguration.class})
@Configuration
public class ProductModelAutoConfiguration {

    @Bean
    public SimpleModule customizeProductModelObjectMapper() {
        SimpleModule module = new SimpleModule("mapProductInterfaces",
                Version.unknownVersion());
        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver() {
            @Override
            public JavaType resolveAbstractType(DeserializationConfig config,
                                                BeanDescription typeDesc) {
                return findTypeMapping(config,
                        typeDesc.getType());
            }
        };

        resolver.addMapping(Product.class,
                ProductImpl.class);

        module.setMixInAnnotation(Feature.class, FeatureMixin.class);
        module.registerSubtypes(new NamedType(StringValueFeatureImpl.class, StringValueFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(StringRangeFeatureImpl.class, StringRangeFeatureImpl.class.getSimpleName()));

        module.registerSubtypes(new NamedType(DataDictValueFeatureImpl.class, DataDictValueFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(DescriptionValueFeatureImpl.class, DescriptionValueFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(DoubleRangeFeatureImpl.class, DoubleRangeFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(DoubleValueFeatureImpl.class, DoubleValueFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(LongRangeFeatureImpl.class, LongRangeFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(LongValueFeatureImpl.class, LongValueFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(FeeItemListFeatureImpl.class, FeeItemListFeatureImpl.class.getSimpleName()));
        module.registerSubtypes(new NamedType(GuaranteeModelListFeatureImpl.class, GuaranteeModelListFeatureImpl.class.getSimpleName()));

        module.setAbstractTypes(resolver);

        return module;
    }
}
