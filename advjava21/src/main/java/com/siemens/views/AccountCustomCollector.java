package com.siemens.views;

import com.siemens.models.AccountAggregator;
import com.siemens.models.SavingsAccount;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AccountCustomCollector implements Collector<SavingsAccount, AccountAggregator,AccountAggregator> {
    @Override
    public Supplier<AccountAggregator> supplier() {
        return AccountAggregator::new;
    }

    @Override
    public BiConsumer<AccountAggregator, SavingsAccount> accumulator() {
        return (pa,p)->{
            pa.setTotalCost(p.getRunningTotal().add(pa.getTotalCost()));
        };
    }

    @Override
    public BinaryOperator<AccountAggregator> combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return (productAggregation ) ->{
            return productAggregation;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return  Collections.emptySet();
    }
}
