package fpc.aoc.day16;

import fpc.aoc.day16._private.Network;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<Valves,Long> {

    @Override
    protected @NonNull Converter<Valves> getConverter() {
        return s -> s.collect(Network.NetworkAggregator.COLLECTOR);
    }
}
