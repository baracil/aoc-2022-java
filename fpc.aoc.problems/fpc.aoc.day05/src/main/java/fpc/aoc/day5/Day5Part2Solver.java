package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day5.struct.Vent;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day5Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Stream<Vent> input) {
        return solve(input, v -> true);
    }
}
