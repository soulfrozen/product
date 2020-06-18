package com.zero.product.core.domain.impl;

import com.zero.product.core.domain.AbstractFeature;
import com.zero.product.core.domain.RangeFeature;

public abstract class RangeFeatureImpl<T> extends AbstractFeature implements RangeFeature {

    private T minValue;

    private T maxValue;

    @Override
    public T getMinValue() {
        return minValue;
    }

    @Override
    public T getMaxValue() {
        return maxValue;
    }

    public void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

}
