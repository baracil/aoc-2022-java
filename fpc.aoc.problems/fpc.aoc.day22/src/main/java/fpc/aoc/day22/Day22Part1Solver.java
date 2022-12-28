package fpc.aoc.day22;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day22Part1Solver extends Day22Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part1Solver().createProblem();
    }

    public Day22Part1Solver() {
        super(NavigationFactory.part1());
    }
}
