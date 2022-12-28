package fpc.aoc.day20;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

//too high 5195
public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem();
    }

    public Day20Part1Solver() {
        super(1,1);
    }
}
