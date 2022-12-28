package fpc.aoc.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day22Solver extends SmartSolver<Input22,Long> {

    @Override
    protected @NonNull Converter<Input22> getConverter() {
        return Converter.ALL_LINES.andThen(Input22::parse);
    }
}
