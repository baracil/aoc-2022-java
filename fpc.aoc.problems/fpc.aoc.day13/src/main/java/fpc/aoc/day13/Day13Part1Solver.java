package fpc.aoc.day13;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day13Part1Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part1Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<PairOfItem> input) {
        return input.stream()
            .filter(PairOfItem::isInCorrectOrder)
            .mapToInt(PairOfItem::index).sum();
    }
}
