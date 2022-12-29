package fpc.aoc.day25;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.stream.Stream;

public abstract class Day25Solver extends SmartSolver<Stream<BigInteger>, String> {

  @Override
  protected @NonNull Converter<Stream<BigInteger>> getConverter() {
    return s -> s.map(Snafu::toValue);
  }

}
