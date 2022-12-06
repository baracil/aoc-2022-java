package fpc.aoc.day6;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day6Part1Solver extends Day6Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day6Part1Solver().createProblem();
    }


    public Day6Part1Solver() {
        super(4);
    }
}
