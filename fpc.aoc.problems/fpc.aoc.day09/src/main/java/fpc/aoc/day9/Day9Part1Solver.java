package fpc.aoc.day9;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.AOCProblem;

@RequiredArgsConstructor
public class Day9Part1Solver extends Day9Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day9Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Map map) {
        return map.computePart1Result();
    }
}
