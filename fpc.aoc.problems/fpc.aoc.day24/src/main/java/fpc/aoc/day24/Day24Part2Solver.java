package fpc.aoc.day24;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day24Part2Solver extends Day24Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day24Part2Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull Map input) {
        return PathFinder.findPathPart2(input).turn();
    }
}
