package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Top;
import lombok.NonNull;

import java.util.stream.LongStream;

public class Day1Part2Solver extends Day1Solver {

    public static AOCProblem<?> provider() {
        return new Day1Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull LongStream input) {
        final var top = new Top(3);
        input.forEach(top::handle);
        return top.sum();
    }

}
