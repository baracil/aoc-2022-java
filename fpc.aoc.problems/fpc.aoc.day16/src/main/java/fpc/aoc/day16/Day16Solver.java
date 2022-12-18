package fpc.aoc.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<Network,Long> {

    @Override
    protected @NonNull Converter<Network> getConverter() {
        return s -> s.collect(NetworkAggregator.COLLECTOR);
    }
}
