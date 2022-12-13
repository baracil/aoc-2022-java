package fpc.aoc.day13;

import com.google.common.collect.ImmutableList;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public abstract class Day13Solver extends SmartSolver<ImmutableList<PairOfItem>, Integer> {

  @Override
  protected @NonNull Converter<ImmutableList<PairOfItem>> getConverter() {
    return s -> {
      final var list = s
          .filter(Predicate.not(String::isEmpty))
          .map(ItemParser::parse)
          .toList();
      return IntStream.iterate(0, i -> i < list.size(), i -> i + 2)
          .mapToObj(i -> new PairOfItem(i / 2 + 1, list.get(i), list.get(i + 1)))
          .collect(ImmutableList.toImmutableList());
    };
  }
}
