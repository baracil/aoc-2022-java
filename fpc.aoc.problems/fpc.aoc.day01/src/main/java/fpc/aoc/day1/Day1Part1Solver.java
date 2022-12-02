package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.util.stream.LongStream;

public class Day1Part1Solver extends Day1Solver {

  public static AOCProblem<?> provider() {
    return new Day1Part1Solver().createProblem();
  }

  @Override
  public @NonNull Long solve(@NonNull LongStream input) {
    return input.max().orElseThrow(() -> new AOCException("Cannot solve"));
  }

}
