package com.zero.product.web.sharding.algorithm;

import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;

public class DefaultDatabaseStrategyRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return null;
    }
}
