package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day12Part2Solver extends Day12Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day12Part2Solver().createProblem();
  }

  public Day12Part2Solver() {
    super(new Part2PathInfo());
  }
}
