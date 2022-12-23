package fpc.aoc.day20;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day20Part2Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part2Solver().createProblem();
    }

    public Day20Part2Solver() {
        super(811589153,10);
    }

}
