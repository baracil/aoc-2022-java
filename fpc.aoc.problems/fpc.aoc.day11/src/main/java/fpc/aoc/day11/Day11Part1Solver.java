package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.function.LongUnaryOperator;

public class Day11Part1Solver extends Day11Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day11Part1Solver().createProblem();
  }


  @Override
  protected int getNumberOfTurns() {
    return 20;
  }

  @Override
  protected LongUnaryOperator createPostOperation(@NonNull ImmutableList<ParsedMonkey> parsedMonkeys) {
    return i -> i / 3;
  }
}
