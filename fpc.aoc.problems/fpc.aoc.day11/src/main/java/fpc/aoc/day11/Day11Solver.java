package fpc.aoc.day11;

import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day11Solver extends SmartSolver<Map,String> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return Converter.ALL_LINES.andThen(ArrayMap::parse);
    }
}
