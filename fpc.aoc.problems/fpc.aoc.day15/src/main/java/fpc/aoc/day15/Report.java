package fpc.aoc.day15;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Report {

  private final @NonNull ImmutableList<SensorReport> reports;


  public long computePart1(int lineIndex) {
    return this.lineCoverage(lineIndex, l -> true)
        .stream()
        .mapToInt(LineCoverage::nbNotDetected)
        .sum();
  }

  public long computePart2(int sup) {
    final var lst = IntStream.rangeClosed(0,sup)
        .mapToObj(i -> this.lineCoverage(i, l -> l.doesNotFullyCover(0,sup)))
        .filter(l -> !l.isEmpty())
        .findAny().orElseThrow(() -> new AOCException("Cannot solve this"));
    return lst.get(0).lineIndex() + (lst.get(0).sup()+1)*4000000L;
  }


  private @NonNull ImmutableList<LineCoverage> lineCoverage(int lineIndex, @NonNull Predicate<LineCoverage> keep) {
    final var lineCoverages = reports.stream()
        .map(r -> r.getCoverage(lineIndex))
        .flatMap(Optional::stream)
        .sorted(Comparator.comparingInt(LineCoverage::inf))
        .toList();

    if (lineCoverages.isEmpty()) {
      return ImmutableList.of();
    }


    final var builder = ImmutableList.<LineCoverage>builder();
    var current = lineCoverages.get(0);
    for (int i = 1; i < lineCoverages.size(); i++) {
      final var next = lineCoverages.get(i);
      final var merged = current.merge(next);

      if (merged == null) {
        if (keep.test(current)) {
          builder.add(current);
        }
        current = next;
      } else {
        current = merged;
      }
    }
    if (keep.test(current)) {
      builder.add(current);
    }

    return builder.build();

  }
}
