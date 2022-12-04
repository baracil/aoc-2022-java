package fpc.aoc.day4;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day4Part1Solver extends Day4Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day4Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<AssignmentPair> input) {
        return (int)input.filter(AssignmentPair::hasSectionFullyContainedInOther).count();
    }
}
