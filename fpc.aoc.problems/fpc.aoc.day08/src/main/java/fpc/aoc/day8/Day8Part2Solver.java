package fpc.aoc.day8;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day8Part2Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Forest forest) {
        return forest.getBestScenicScore();
    }
}
