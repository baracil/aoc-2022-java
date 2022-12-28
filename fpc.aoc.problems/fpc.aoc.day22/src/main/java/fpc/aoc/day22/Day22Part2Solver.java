package fpc.aoc.day22;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day22Part2Solver extends Day22Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part2Solver().createProblem();
    }

    public Day22Part2Solver() {
        super(NavigationFactory.part2());
    }
}
