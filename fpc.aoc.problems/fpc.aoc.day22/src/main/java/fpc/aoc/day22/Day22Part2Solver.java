package fpc.aoc.day22;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day22Part2Solver extends Day22Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part2Solver().createProblem();
    }

    @Override
    public boolean isSkipped() {
        return true;
    }

    @Override
    public @NonNull Long solve(@NonNull Input22 input) {
        return null;
    }
}
