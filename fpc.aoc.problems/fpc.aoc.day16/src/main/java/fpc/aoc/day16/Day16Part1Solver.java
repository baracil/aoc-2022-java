package fpc.aoc.day16;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

public class Day16Part1Solver extends Day16Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day16Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Network network) {

        network.simplify();
        network.dump();
        throw new NotSolvedYet();
    }
}
