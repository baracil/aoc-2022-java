package fpc.aoc.day14;

import fpc.aoc.day14.struct.Counter;
import fpc.aoc.day14.struct.Input;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day14Part1Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Input input) {
        final var counter = new Counter(input.template(), input.rules());
        return String.valueOf(counter.compute(10));
    }
}
