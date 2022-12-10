package fpc.aoc.day9;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day9Part1Solver extends Day9Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day9Part1Solver().createProblem();
    }

    public Day9Part1Solver() {
        super(2);
    }
}
