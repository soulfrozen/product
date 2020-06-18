package com.zero.product.web.entity;

import com.zero.common.core.domain.BasicEntity;

public class ProductCategoryFeatureEntity extends BasicEntity<String>  {

    private String category;

    private String name;

    private String description;

    private String valueType;

    private String dictCode;

    private String clazz;

    private String checkRule;

    // 0 可选  1 必选
    private String optional;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(String checkRule) {
        this.checkRule = checkRule;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getOptional() {
        return optional;
    }

}
