package fpc.aoc.day3;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day3Part1Solver extends SmartSolver<Stream<Rucksack>, Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<Stream<Rucksack>> getConverter() {
        return s -> s.map(Rucksack::parse);
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<Rucksack> input) {
        return input.mapToInt(i -> i.findItemInBothCompartments() + 1).sum();
    }
}
