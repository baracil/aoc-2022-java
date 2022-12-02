package fpc.aoc.day4;

import fpc.aoc.common.AOCException;
import fpc.aoc.day4.struct.Day04Input;
import fpc.aoc.day4.struct.GridState;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day4Part2Solver extends Day4Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day4Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Day04Input input) {
        Day04Input current = input;
        do {
            final var newInput = current.playOneRoundPart2().orElse(null);
            if (newInput == null) {
                return switch (current.gridState()) {
                    case GridState.Winning winning -> String.valueOf(winning.score());
                    case GridState.NotWinning ignored -> throw new AOCException("Cannot solve the problem");
                };
            }
            current = newInput;
        } while (true);
    }
}
