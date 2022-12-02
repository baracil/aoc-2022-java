package fpc.aoc.day16;

import fpc.aoc.day16.struct.Packet;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day16Part1Solver extends Day16Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day16Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Packet packet) {
        return packet.sumOfVersions();
    }

}
