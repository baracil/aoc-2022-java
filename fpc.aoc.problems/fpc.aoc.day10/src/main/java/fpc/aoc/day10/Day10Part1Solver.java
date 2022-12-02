package fpc.aoc.day10;

import fpc.aoc.day10.structures.SyntaxChecker;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day10Part1Solver extends Day10Solver<Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<String> input) {
        return input.mapToInt(SyntaxChecker.create()::check)
                    .sum();
    }
}
