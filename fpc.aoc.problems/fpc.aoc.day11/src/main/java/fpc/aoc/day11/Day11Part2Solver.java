package fpc.aoc.day11;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day11Part2Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Map map) {
        int step = 0;
        do {
            step +=1;
            if (map.executeOneStep()) {
                return String.valueOf(step);
            }
        } while (true);


    }
}
