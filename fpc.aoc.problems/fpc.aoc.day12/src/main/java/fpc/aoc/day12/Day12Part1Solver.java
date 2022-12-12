package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day12Part1Solver extends Day12Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part1Solver().createProblem();
    }

    public Day12Part1Solver() {
        super(new Part1PathInfo());
    }
}
