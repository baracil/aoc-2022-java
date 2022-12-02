package fpc.aoc.day2;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day2Part2Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part2Solver().createProblem();
    }


    public Day2Part2Solver() {
        super(Turn::forPart2);
    }
}
