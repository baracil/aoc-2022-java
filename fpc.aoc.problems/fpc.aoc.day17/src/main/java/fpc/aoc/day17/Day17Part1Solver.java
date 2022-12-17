package fpc.aoc.day17;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day17Part1Solver extends Day17Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day17Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Game game) {
        for (int i = 0; i < 2022; i++) {
            game.fallOnePiece();
        }
        return game.getTowerHeight();
    }

}
