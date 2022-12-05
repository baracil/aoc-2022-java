package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day5Part2Solver extends Day5Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day5Part2Solver().createProblem();
  }

  public Day5Part2Solver() {
    super(new CrateMover9001());
  }
}
