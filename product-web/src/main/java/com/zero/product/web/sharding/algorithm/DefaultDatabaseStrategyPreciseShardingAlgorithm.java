package com.zero.product.web.sharding.algorithm;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultDatabaseStrategyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        int size = availableTargetNames.size();
        String value = shardingValue.getValue();
        int i = (value.hashCode() >>> 1) % size;
        return new ArrayList<String>(availableTargetNames).get(i);
    }
}
