package fpc.aoc.day13;

import fpc.aoc.day13.struct.Input;
import fpc.aoc.day13.struct.Sheet;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day13Part2Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Input input) {
        final var sheet = input.folds()
                               .stream()
                               .reduce(input.sheet(), Sheet::fold,(s1, s2) -> {throw new UnsupportedOperationException();});

        return sheet.toDisplay();
    }

}
