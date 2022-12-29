package fpc.aoc.day16;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day16Part2Solver extends Day16Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day16Part2Solver().createProblem();
  }

  @Override
  public @NonNull Long solve(@NonNull Valves input) {
    final var solver = new Solver(input);
    return input.generateBalancedPartitions()
        .parallel()
        .mapToLong(p -> {
          final var r1 = solver.solve(p.first(), 26);
          final var r2 = solver.solve(p.second(), 26);
          return r1 + r2;
        }).max()
        .orElseThrow();
  }
}
