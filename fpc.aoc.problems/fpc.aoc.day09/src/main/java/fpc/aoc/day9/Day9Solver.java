package fpc.aoc.day9;

import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day9Solver extends SmartSolver<Map,Integer> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return Converter.ALL_LINES.andThen(Map::parse);
    }
}
