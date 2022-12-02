package fpc.aoc.day6;

import fpc.aoc.day6.struct.School;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day6Part2Solver extends Day6Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day6Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull School input) {
        return input.compute_population(GEN_256).toString();
    }
}
