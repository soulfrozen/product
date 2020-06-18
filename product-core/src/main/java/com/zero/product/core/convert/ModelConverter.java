package com.zero.product.core.convert;

import java.util.Collection;
import java.util.List;

public interface ModelConverter<SOURCE, TARGET> {

    TARGET from(SOURCE source);

    List<TARGET> from(Collection<SOURCE> sources);
}
