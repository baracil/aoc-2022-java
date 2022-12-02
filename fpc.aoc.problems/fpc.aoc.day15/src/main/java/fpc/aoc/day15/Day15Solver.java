package fpc.aoc.day15;

import fpc.aoc.day15.struct.Map;
import fpc.aoc.day15.struct.PathFinder;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day15Solver extends SmartSolver<Map,String> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return Converter.ALL_LINES.andThen(l -> Map.parse(l,getNbRepetitions()));
    }


    protected abstract int getNbRepetitions();

    @Override
    public @NonNull String solve(@NonNull Map input) {
        return String.valueOf(new PathFinder().findLowestRisk(input));
    }
}
