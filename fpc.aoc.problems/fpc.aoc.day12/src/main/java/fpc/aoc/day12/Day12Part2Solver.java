package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day12.struct.Part2RecursiveMode;
import fpc.aoc.day12.struct.RecursiveMode;
import lombok.NonNull;

public class Day12Part2Solver extends Day12Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part2Solver().createProblem();
    }

    @Override
    protected RecursiveMode getRecursiveMode() {
        return new Part2RecursiveMode();
    }
}
