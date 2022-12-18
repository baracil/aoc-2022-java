package fpc.aoc.day16;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

public class Day16Part2Solver extends Day16Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day16Part2Solver().createProblem();
  }

  @Override
  public @NonNull Long solve(@NonNull Network network) {
    final var step = PathFinderPart2.findBest(network);
    step.dump(System.out);
    return (long)step.totalVent();
  }
}
