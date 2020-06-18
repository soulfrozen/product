package com.zero.product.core.domain.impl;

import com.zero.product.core.domain.AbstractFeature;
import com.zero.product.core.domain.ValueFeature;

public abstract class ValueFeatureImpl<T> extends AbstractFeature implements ValueFeature {

    private T value;

    @Override
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
