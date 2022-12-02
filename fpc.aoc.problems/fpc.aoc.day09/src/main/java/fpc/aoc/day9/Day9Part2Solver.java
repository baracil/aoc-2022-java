package fpc.aoc.day9;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class Day9Part2Solver extends Day9Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day9Part2Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull Map map) {
        return map.computePart2Result();
    }
}
