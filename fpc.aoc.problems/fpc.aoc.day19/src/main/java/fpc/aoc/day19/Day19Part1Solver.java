package fpc.aoc.day19;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day19Part1Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part1Solver().createProblem();
    }


    @Override
    public @NonNull Long solve(@NonNull Stream<BluePrint> input) {
        return input
            .parallel()
            .mapToLong(this::compute)
            .sum();
    }

    private long compute(@NonNull BluePrint bluePrint) {
        return Factory.findBest(bluePrint,24).getQualityLevel();
    }

}
