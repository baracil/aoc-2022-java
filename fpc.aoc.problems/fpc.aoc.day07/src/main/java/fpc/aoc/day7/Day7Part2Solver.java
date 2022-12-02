package fpc.aoc.day7;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day7Part2Solver extends Day7Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day7Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(int @NonNull [] input) {
        final var mean = Arrays.stream(input).average().orElseThrow();
        final var targetInf = (int)Math.floor(mean);
        final var targetSup = (int)Math.ceil(mean);

        final IntUnaryOperator fueldComputer = target -> Arrays.stream(input).map(i -> computeFuel(i,target)).sum();

        return IntStream.of(targetInf, targetSup).map(fueldComputer).min().orElse(0);
    }

    private int computeFuel(int position, int target) {
        final var dif = Math.abs(position - target);
        return dif*(dif+1)/2;
    }
}
