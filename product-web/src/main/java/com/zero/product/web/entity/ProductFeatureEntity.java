package com.zero.product.web.entity;

import com.zero.common.core.domain.BasicEntity;

public class ProductFeatureEntity extends BasicEntity<String> {

    private String productCode;

    private String name;

    private String value;

    private String minValue;

    private String maxValue;

    // 属性类型(0-范围值，1-字典值，2-固定值 3 description 4 list<T>  其中3,4 值存储到textEntity中， 自身value 存储textEntity textId)
    private String valueType;

    private String clazz;

    private String dictCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
}
