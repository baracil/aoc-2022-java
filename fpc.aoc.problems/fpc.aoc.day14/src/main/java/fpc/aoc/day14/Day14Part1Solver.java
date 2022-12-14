package fpc.aoc.day14;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day14Part1Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part1Solver().createProblem();
    }

    public Day14Part1Solver() {
        super(Cave::dropSandPart1);
    }
}
