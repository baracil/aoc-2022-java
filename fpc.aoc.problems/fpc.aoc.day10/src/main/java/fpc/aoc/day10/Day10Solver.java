package fpc.aoc.day10;

import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day10Solver<T> extends SmartSolver<Stream<String>,T> {


    @Override
    protected @NonNull Converter<Stream<String>> getConverter() {
        return Converter.IDENTITY;
    }
}
