package fpc.aoc.day18;

import fpc.aoc.day18.struct.Number;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day18Solver extends SmartSolver<Stream<Number>, Long> {

    @Override
    protected @NonNull Converter<Stream<Number>> getConverter() {
        return s -> s.map(Number::parse);
    }
}
