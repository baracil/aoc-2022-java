package fpc.aoc.day25;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Day25Part1Solver extends Day25Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day25Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Stream<BigInteger> input) {
        final var sum = input.reduce(BigInteger.ZERO, BigInteger::add);
        return Snafu.toSnafu(sum);
    }
}
