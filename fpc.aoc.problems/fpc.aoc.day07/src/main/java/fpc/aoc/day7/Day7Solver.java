package fpc.aoc.day7;

import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class Day7Solver extends SmartSolver<int[],Integer> {

    @Override
    protected @NonNull Converter<int[]> getConverter() {
        return Converter.FIRST_LINE.andThen(this::toArrayOfInt);
    }

    private int[] toArrayOfInt(@NonNull String line) {
        return Arrays.stream(line.split(","))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}
