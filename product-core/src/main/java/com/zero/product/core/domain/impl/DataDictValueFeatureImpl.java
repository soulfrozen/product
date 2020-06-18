package com.zero.product.core.domain.impl;

public class DataDictValueFeatureImpl extends ValueFeatureImpl<String> {

    private String dictCode;

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictCode() {
        return dictCode;
    }
}
