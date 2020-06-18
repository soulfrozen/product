package com.zero.product.web.model;

import com.zero.common.core.util.JsonUtil;
import com.zero.product.core.domain.*;
import com.zero.product.core.domain.impl.*;
import com.zero.product.core.convert.ListConverter;
import com.zero.product.core.convert.ModelConverter;
import com.zero.product.web.entity.ProductFeatureEntity;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

@Component
public class FeatureConverter extends ListConverter<ProductFeatureEntity, Feature> implements ModelConverter<ProductFeatureEntity, Feature> {

    @Override
    public Feature from(ProductFeatureEntity entity) {

        Feature o = null;
        Class<?> aClass = null;
        try {
            aClass = Class.forName(entity.getClazz());
            o = (Feature) ReflectUtils.newInstance(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class type = (Class) ((ParameterizedType)aClass.getGenericSuperclass()).getActualTypeArguments()[0];

        // TODO 需要 支持其他类型
        if (o instanceof RangeFeatureImpl) {
            RangeFeatureImpl rangeFeature = (RangeFeatureImpl) o;

            rangeFeature.setMaxValue(getActualValue(type, entity.getMaxValue()));
            rangeFeature.setMinValue(getActualValue(type, entity.getMinValue()));
            rangeFeature.setName(entity.getName());
            rangeFeature.setProductCode(entity.getProductCode());
            return rangeFeature;
        }

        if (o instanceof ValueFeature) {
            ValueFeatureImpl valueFeature = (ValueFeatureImpl) o;
            valueFeature.setValue(getActualValue(type, entity.getValue()));
            valueFeature.setProductCode(entity.getProductCode());
            valueFeature.setName(entity.getName());
            if (valueFeature instanceof DataDictValueFeatureImpl) {
                DataDictValueFeatureImpl dataDictValueFeature = (DataDictValueFeatureImpl) valueFeature;
                dataDictValueFeature.setDictCode(entity.getDictCode());
            }

            return valueFeature;
        }

        if (o instanceof ListFeature) {

            ListFeatureImpl listValueFeature = (ListFeatureImpl) o;
            listValueFeature.setProductCode(entity.getProductCode());
            listValueFeature.setName(entity.getName());
            listValueFeature.setValues(JsonUtil.toList(entity.getValue(), type));

            return listValueFeature;
        }
        return null;
    }

    public Object getActualValue(Class c, String value) {
        if (c.equals(String.class)) {
            return value;
        }
        if (c.equals(Long.class)) {
            return Long.valueOf(value);
        }
        if (c.equals(Double.class)) {
            return Double.valueOf(value);
        }
        // TODO
        return null;
    }

}
