package com.zero.product.web.model;

import com.zero.common.core.util.JsonUtil;
import com.zero.product.core.convert.ListConverter;
import com.zero.product.core.convert.ModelConverter;
import com.zero.product.core.domain.*;
import com.zero.product.core.domain.impl.DataDictValueFeatureImpl;
import com.zero.product.web.entity.ProductFeatureEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityFeatureConverter extends ListConverter<Feature, ProductFeatureEntity> implements ModelConverter<Feature, ProductFeatureEntity> {

    @Override
    public ProductFeatureEntity from(Feature feature) {
        ProductFeatureEntity featureEntity = new ProductFeatureEntity();
        featureEntity.setProductCode(feature.getProductCode());
        featureEntity.setName(feature.getName());
        featureEntity.setClazz(feature.getClass().getName());
        if (feature instanceof RangeFeature) {
            RangeFeature rangeFeature = (RangeFeature) feature;
            featureEntity.setValueType("0");
            featureEntity.setMinValue(String.valueOf(rangeFeature.getMinValue()));
            featureEntity.setMaxValue(String.valueOf(rangeFeature.getMaxValue()));
        } else if (feature instanceof DataDictValueFeatureImpl) {
            DataDictValueFeatureImpl valueFeature = (DataDictValueFeatureImpl) feature;
            featureEntity.setValueType("2");
            featureEntity.setValue(String.valueOf(valueFeature.getValue()));
            featureEntity.setDictCode(valueFeature.getDictCode());
        } else if (feature instanceof ValueFeature) {
            ValueFeature valueFeature = (ValueFeature) feature;
            featureEntity.setValueType("1");
            featureEntity.setValue(String.valueOf(valueFeature.getValue()));
            if (feature instanceof Description) {
                featureEntity.setValueType("3");
            }
        } else if (feature instanceof ListFeature) {
            ListFeature listFeature = (ListFeature) feature;
            ((ListFeature) feature).getValues();
            featureEntity.setValueType("4");
            featureEntity.setValue(JsonUtil.toJson(listFeature.getValues()));
        }

        return featureEntity;
    }

}
