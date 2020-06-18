package com.zero.product.core.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ListConverter<SOURCE, TARGET> implements ModelConverter<SOURCE, TARGET> {

    @Override
    public List<TARGET> from(Collection<SOURCE> sources) {
        List<TARGET> targetElements = new ArrayList<>();
        for (SOURCE sourceElement : sources) {
            targetElements.add(from(sourceElement));
        }
        return targetElements;
    }

}
