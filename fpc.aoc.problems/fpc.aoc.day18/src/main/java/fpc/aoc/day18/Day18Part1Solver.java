package fpc.aoc.day18;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day18Part1Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableSet<Face> input) {
        return input.size();
    }
}
