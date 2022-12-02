package fpc.aoc.day13;

import fpc.aoc.day13.struct.Input;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day13Part1Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Input input) {
        final var fold = input.folds().get(0);

        final var sheet = input.sheet().fold(fold);

        return String.valueOf(sheet.getNumberOfDots());
    }
}
