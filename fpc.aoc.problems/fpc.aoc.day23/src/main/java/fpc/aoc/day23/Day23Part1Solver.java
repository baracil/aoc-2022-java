package fpc.aoc.day23;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day23Part1Solver extends Day23Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day23Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Elves elves) {
        var current = elves;
        for (int i = 0; i < 10; i++) {
            current = current.performOneRound();
        }
        return current.nbEmptyGrounds();
    }
}
