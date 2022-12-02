package fpc.aoc.day10;

import fpc.aoc.common.Pair;
import fpc.aoc.day10.structures.CompleterChecker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.AOCProblem;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Day10Part2Solver extends Day10Solver<String> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Stream<String> input) {
        final var scores = input.map(this::complete)
//                                .peek(p -> System.out.printf("%s -> %s%n", p.first(), p.second()))
                                .flatMap(p -> p.second().stream())
                                .sorted()
                                .toArray();

        return scores[scores.length / 2].toString();
    }

    public @NonNull Pair<String, Optional<BigInteger>> complete(@NonNull String line) {
        final var score = CompleterChecker.create().complete(line);
        return Pair.of(line, score);
    }
}




