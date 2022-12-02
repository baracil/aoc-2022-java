package fpc.aoc.day17;

import fpc.aoc.day17.struct.ProbeTester;
import fpc.aoc.day17.struct.Target;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class Day17Part2Solver extends Day17Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day17Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Target input) {
        final var tester = new ProbeTester(input);
        return input.searchSpace().filter(tester::willReach).count();
    }
}
