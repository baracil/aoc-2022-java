package fpc.aoc.day15;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

public record SensorReport(@NonNull Position sensor, @NonNull Position beacon, int distanceCovered) {


  public Optional<LineCoverage> getCoverage(int lineIndex) {
    final var minDistance = Math.abs(sensor.y() - lineIndex);
    if (minDistance > distanceCovered) {
      return Optional.empty();
    }
    final int margin = distanceCovered - minDistance;
    return Optional.of(new LineCoverage(beacon.y() == lineIndex? ImmutableSet.of(beacon.x()):ImmutableSet.of(), lineIndex,-margin + sensor.x(), margin + sensor.x()));
  }


  private static final Pattern PATTERN = Pattern.compile(".* x=(?<sx>[-0-9]+), y=(?<sy>[-0-9]+).* x=(?<bx>[-0-9]+), y=(?<by>[-0-9]+)");


  public static SensorReport parse(@NonNull String line) {
    final var match = PATTERN.matcher(line);
    if (!match.matches()) {
      throw new AOCException("Cannot parse record line '" + line + "'");
    }

    final ToIntFunction<String> getter = s -> Integer.parseInt(match.group(s));

    final var sensor = Position.of(getter.applyAsInt("sx"), getter.applyAsInt("sy"));
    final var beacon = Position.of(getter.applyAsInt("bx"), getter.applyAsInt("by"));

    return new SensorReport(sensor, beacon, sensor.manhattanDistanceTo(beacon));
  }

}
