package fpc.aoc.day2;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part2Solver().createProblem();
    }


    public Day2Part2Solver() {
        super(Turn::forPart2);
    }
}
