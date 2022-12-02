package fpc.aoc.day11;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day11Part1Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Map map) {
        for (int i = 0; i < 100; i++) {
            map.executeOneStep();
        }
        return String.valueOf(map.numberOfFlashes());

    }
}
