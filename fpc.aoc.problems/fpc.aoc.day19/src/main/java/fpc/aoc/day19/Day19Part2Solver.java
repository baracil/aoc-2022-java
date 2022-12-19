package fpc.aoc.day19;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day19Part2Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part2Solver().createProblem();
    }


    @Override
    public @NonNull Long solve(@NonNull Stream<BluePrint> input) {
        return input
            .limit(3)
            .parallel()
            .mapToLong(this::compute)
            .reduce(1,(a,b) -> a*b);
    }

    private long compute(@NonNull BluePrint bluePrint) {
        return Factory.findBest(bluePrint,32).nbGeode();
    }

}
