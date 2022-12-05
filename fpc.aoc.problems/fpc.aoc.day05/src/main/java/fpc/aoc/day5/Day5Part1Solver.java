package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day5Part1Solver extends Day5Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day5Part1Solver().createProblem();
  }

  public Day5Part1Solver() {
    super(new CrateMover9000());
  }
}
