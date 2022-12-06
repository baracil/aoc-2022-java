package fpc.aoc.day6;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day6Part2Solver extends Day6Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day6Part2Solver().createProblem();
    }

    public Day6Part2Solver() {
        super(14);
    }
}
