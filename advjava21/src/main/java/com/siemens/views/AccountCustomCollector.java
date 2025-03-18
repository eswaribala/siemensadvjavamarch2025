package com.siemens.views;

import com.siemens.models.AccountAggregator;
import com.siemens.models.SavingsAccount;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AccountCustomCollector implements Collector<SavingsAccount, AccountAggregator,AccountAggregator> {
    @Override
    public Supplier<AccountAggregator> supplier() {
        return null;
    }

    @Override
    public BiConsumer<AccountAggregator, SavingsAccount> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<AccountAggregator> combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
