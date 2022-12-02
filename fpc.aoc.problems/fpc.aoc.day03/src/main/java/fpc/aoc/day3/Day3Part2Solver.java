package fpc.aoc.day3;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day3Part2Solver extends Day3Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Stream<String> input) {
        throw new NotSolvedYet();
    }
}
