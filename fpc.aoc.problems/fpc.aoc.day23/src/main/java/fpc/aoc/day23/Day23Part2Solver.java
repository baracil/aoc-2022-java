package fpc.aoc.day23;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day23Part2Solver extends Day23Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day23Part2Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull Elves input) {
        var current = input;
        int nbRound = 0;
        do {
            current = current.performOneRound();
            nbRound++;
        } while (!current.allIsolated());
        return nbRound;
    }
}
