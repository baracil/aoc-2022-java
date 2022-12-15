package fpc.aoc.day15;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part2Solver().createProblem();
    }

    private final int sup;

    public Day15Part2Solver(int sup) {
        this.sup = sup;
    }

    public Day15Part2Solver() {
        this.sup = 4_000_000;
    }

    @Override
    public @NonNull Long solve(@NonNull Report report) {
        return report.computePart2(sup);
    }
}
