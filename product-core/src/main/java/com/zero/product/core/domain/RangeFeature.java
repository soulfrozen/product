package com.zero.product.core.domain;

public interface RangeFeature<T> extends Feature {

    T getMinValue();

    T getMaxValue();
}
