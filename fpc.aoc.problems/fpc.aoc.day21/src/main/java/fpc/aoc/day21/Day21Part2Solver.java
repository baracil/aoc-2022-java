package fpc.aoc.day21;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day21Part2Solver extends Day21Solver<Op> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day21Part2Solver().createProblem();
    }

    public Day21Part2Solver() {
        super(new MonkeyEvaluatorPart2());
    }

    @Override
    protected Long finalize(Op rootResult) {
        return rootResult.toGetZero().round();
    }

}
