package com.zero.product.api.convert;

import com.zero.product.core.domain.*;
import com.zero.product.core.convert.ListConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApiProductMapConverter extends ListConverter<Product, Map<String, Object>> {

    @Override
    public Map<String, Object> from(Product product) {

        Map<String, Object> result = new HashMap<>();
        result.put("productCode", product.getProductCode());
        result.put("productName", product.getProductName());
        result.put("description", product.getDescription());
        result.put("tenantId", product.getTenantId());
        result.put("busiType", product.getBusiType());
        result.put("category", product.getCategory());

        List<Feature> features = product.getFeatures();
        for (Feature feature : features) {

            if (feature instanceof ValueFeature) {
                result.put(feature.getName(), ((ValueFeature) feature).getValue());
            }
            if (feature instanceof RangeFeature) {
                String firstCharUpperCaseName = firstCharUpperCase(feature.getName());
                String minName = "min" + firstCharUpperCaseName;
                String maxName = "max" + firstCharUpperCaseName;
                result.put(minName, ((RangeFeature) feature).getMinValue());
                result.put(maxName, ((RangeFeature) feature).getMaxValue());
            }

            if (feature instanceof ListFeature) {
                result.put(feature.getName(), ((ListFeature) feature).getValues());
            }
        }

        return result;
    }

    public String firstCharUpperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
