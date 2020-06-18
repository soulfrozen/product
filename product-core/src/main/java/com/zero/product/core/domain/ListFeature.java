package com.zero.product.core.domain;

import java.util.List;

public interface ListFeature<T> extends Feature<List<T>> {

    List<T> getValues();

}
