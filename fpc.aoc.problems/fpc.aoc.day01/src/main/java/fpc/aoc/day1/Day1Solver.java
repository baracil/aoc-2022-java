package fpc.aoc.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<LongStream, Long> {

  @Override
  protected @NonNull Converter<LongStream> getConverter() {
    return Converter.ALL_LINES.andThen(CarriedCalory::new).andThen(itr -> StreamSupport.stream(itr.spliterator(),false).mapToLong(l -> l));
  }



}
