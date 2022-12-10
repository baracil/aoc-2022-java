package fpc.aoc.day10;

import com.google.common.collect.ImmutableList;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day10Solver<T> extends SmartSolver<ImmutableList<Command>,T> {

    @Override
    protected @NonNull Converter<ImmutableList<Command>> getConverter() {
        return s -> s.map(Command::parse).collect(ImmutableList.toImmutableList());
    }
}
