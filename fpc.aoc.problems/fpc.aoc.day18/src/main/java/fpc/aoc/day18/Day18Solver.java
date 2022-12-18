package fpc.aoc.day18;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class Day18Solver extends SmartSolver<ImmutableSet<Face>, Integer> {

  @Override
  protected @NonNull Converter<ImmutableSet<Face>> getConverter() {
    return s -> s.map(Cube::parse)
        .flatMap(Cube::faces)
        .collect(Collectors.groupingBy(f -> f, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(ImmutableSet.toImmutableSet());
  }
}
