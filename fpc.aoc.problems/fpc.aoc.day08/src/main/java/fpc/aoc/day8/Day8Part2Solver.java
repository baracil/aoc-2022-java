package fpc.aoc.day8;

import fpc.aoc.day8.struct.Decoder;
import fpc.aoc.day8.struct.WiringInfo;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<WiringInfo<String>> input) {
        return input.map(Decoder::decode)
                    .mapToLong(WiringInfo::display)
                    .sum();

    }
}
