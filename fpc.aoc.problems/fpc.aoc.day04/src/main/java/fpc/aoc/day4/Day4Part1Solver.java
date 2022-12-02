package fpc.aoc.day4;

import fpc.aoc.common.AOCException;
import fpc.aoc.day4.struct.Day04Input;
import fpc.aoc.day4.struct.GridState;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day4Part1Solver extends Day4Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day4Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Day04Input input) {
        Day04Input current = input;
        do {
            final var newState = current.playOneRoundPart1().orElse(null);
            if (newState == null) {
                throw new AOCException("Cannot solve the problem");
            }
            if (newState.gridState() instanceof GridState.Winning winning) {
                return String.valueOf(winning.score());
            }
            current = newState;
        } while (true);
    }
}
