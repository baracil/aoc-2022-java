package fpc.aoc.day18;

import com.google.common.collect.ImmutableList;
import fpc.aoc.day18.struct.Number;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day18Part2Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<Number> input) {
        final var numbers = input.collect(ImmutableList.toImmutableList());


        return IntStream.range(0, numbers.size() - 1)
                .mapToObj(i -> IntStream.range(i + 1, numbers.size()).mapToLong(j -> maxMagnitude(numbers.get(i), numbers.get(j))).boxed())
                .flatMap(s -> s)
                .mapToLong(s -> s)
                .max()
                .orElseThrow();

    }

    private long maxMagnitude(Number number1, Number number2) {
        final var mag1 = number1.add(number2).magnitude();
        final var mag2 = number2.add(number1).magnitude();
        return Math.max(mag1,mag2);
    }
}
