package fpc.aoc.day14;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day14Part2Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part2Solver().createProblem();
    }

    public Day14Part2Solver() {
        super(Cave::dropSandPart2);
    }
}
