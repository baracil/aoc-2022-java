package fpc.aoc.day21;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day21Part1Solver extends Day21Solver<Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day21Part1Solver().createProblem();
    }

    public Day21Part1Solver() {
        super(new MonkeyEvaluatorPart1());
    }

    @Override
    protected Long finalize(Long rootResult) {
        return rootResult;
    }
}
