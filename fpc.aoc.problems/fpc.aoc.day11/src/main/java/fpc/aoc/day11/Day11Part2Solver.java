package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.function.LongUnaryOperator;

public class Day11Part2Solver extends Day11Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day11Part2Solver().createProblem();
  }


  @Override
  protected int getNumberOfTurns() {
    return 10_000;
  }

  @Override
  protected LongUnaryOperator createPostOperation(@NonNull ImmutableList<ParsedMonkey> parsedMonkeys) {
    final var mod = parsedMonkeys.stream().mapToInt(ParsedMonkey::divisor).reduce(1, (a, b) -> a * b);
    return i -> i % mod;
  }
}
