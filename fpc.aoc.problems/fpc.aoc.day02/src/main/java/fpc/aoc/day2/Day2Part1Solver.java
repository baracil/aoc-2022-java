package fpc.aoc.day2;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day2Part1Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part1Solver().createProblem();
    }

    public Day2Part1Solver() {
        super(Turn::forPart1);
    }

}
