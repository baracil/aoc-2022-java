package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day12.struct.Part1RecursiveMode;
import fpc.aoc.day12.struct.RecursiveMode;
import lombok.NonNull;

public class Day12Part1Solver extends Day12Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part1Solver().createProblem();
    }

    @Override
    protected RecursiveMode getRecursiveMode() {
        return new Part1RecursiveMode();
    }
}
