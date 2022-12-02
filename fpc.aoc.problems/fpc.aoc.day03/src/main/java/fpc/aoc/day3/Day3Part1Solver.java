package fpc.aoc.day3;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day3Part1Solver extends Day3Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Stream<String> input) {
        throw new NotSolvedYet();
    }

}
