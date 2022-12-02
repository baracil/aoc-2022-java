package fpc.aoc.day7;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day7Part1Solver extends Day7Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day7Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(int @NonNull [] input) {
        Arrays.sort(input);
        final var target = input[input.length/2];

        return Arrays.stream(input).map(i -> computeFuel(i, target)).sum();
    }

    public int computeFuel(int position, int target) {
        return Math.abs(position-target);
    }
}
