package fpc.aoc.day17;

import fpc.aoc.day17.struct.ProbeTester;
import fpc.aoc.day17.struct.Target;
import fpc.aoc.day17.struct.Vec;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day17Part1Solver extends Day17Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day17Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Target input) {
        final var tester = new ProbeTester(input);
        final var maxy = input.searchSpace()
                              .filter(tester::willReach)
                              .mapToInt(Vec::y)
                              .max()
                              .orElseThrow();
        return maxy * (maxy + 1L) / 2;
    }
}
