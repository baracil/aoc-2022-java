package fpc.aoc.day18;

import fpc.aoc.day18.struct.Number;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day18Part1Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<Number> input) {
        return input.reduce(Number.NIL, Number::add).magnitude();
    }
}
