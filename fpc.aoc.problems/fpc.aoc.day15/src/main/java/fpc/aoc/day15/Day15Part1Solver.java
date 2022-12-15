package fpc.aoc.day15;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day15Part1Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part1Solver().createProblem();
    }

    private final int lineNumber;

    public Day15Part1Solver(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Day15Part1Solver() {
        lineNumber = 2000000;
    }

    @Override
    public @NonNull Long solve(@NonNull Report input) {
        return input.computePart1(lineNumber);
    }
}
