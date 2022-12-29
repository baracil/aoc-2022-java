package fpc.aoc.day24;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day24Part1Solver extends Day24Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day24Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Map input) {
        final var path = PathFinder.findPathPart1(input);
        return path.turn();
    }
}
