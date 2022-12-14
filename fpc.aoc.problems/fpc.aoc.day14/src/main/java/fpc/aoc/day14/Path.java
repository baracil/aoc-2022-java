package fpc.aoc.day14;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public record Path(@NonNull ImmutableList<Position> points) {

  public Stream<Position> positions() {
    return IntStream.range(1, points.size())
        .mapToObj(i -> linePosition(points.get(i - 1), points.get(i)))
        .flatMap(s -> s);
  }

  private Stream<Position> linePosition(@NonNull Position start, @NonNull Position end) {
    final int dx = end.x() - start.x();
    final int dy = end.y() - start.y();

    if (dx == 0 && dy == 0) {
      return Stream.of(start);
    }
    if (dx != 0 && dy != 0) {
      throw new AOCException("Dunno");
    }
    final int n = Math.max(Math.abs(dx), Math.abs(dy));
    final int ddx = Integer.compare(dx, 0);
    final int ddy = Integer.compare(dy, 0);
    return IntStream.rangeClosed(0, n).mapToObj(i -> start.translate(ddx * i, ddy * i));
  }


  public static Path parse(@NonNull String line) {
    final var points = Arrays.stream(line.split(" -> "))
        .map(Position::parseCommaSeparated)
        .collect(ImmutableList.toImmutableList());
    return new Path(points);
  }


}
