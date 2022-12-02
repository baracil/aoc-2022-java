package fpc.aoc.day8;

import fpc.aoc.day8.struct.WiringInfo;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.Collection;
import java.util.stream.Stream;

public class Day8Part1Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<WiringInfo<String>> input) {
        return input.map(WiringInfo::digits)
                    .flatMap(Collection::stream)
                    .map(String::length)
                    .filter(l -> l == 2 || l == 3 || l == 4 || l == 7)
                    .count();
    }
}
