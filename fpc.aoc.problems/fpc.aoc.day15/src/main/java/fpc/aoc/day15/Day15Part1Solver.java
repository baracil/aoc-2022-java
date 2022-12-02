package fpc.aoc.day15;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day15Part1Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part1Solver().createProblem();
    }

    @Override
    protected int getNbRepetitions() {
        return 1;
    }
}
