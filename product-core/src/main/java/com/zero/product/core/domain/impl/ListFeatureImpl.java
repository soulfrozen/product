package com.zero.product.core.domain.impl;

import com.zero.product.core.domain.AbstractFeature;
import com.zero.product.core.domain.ListFeature;

import java.util.List;


public abstract class ListFeatureImpl<T> extends AbstractFeature implements ListFeature {

    private List<T> values;

    @Override
    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

}
