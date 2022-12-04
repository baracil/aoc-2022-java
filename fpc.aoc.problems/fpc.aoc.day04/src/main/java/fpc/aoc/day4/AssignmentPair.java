package fpc.aoc.day4;

import fpc.aoc.common.IntRange;
import lombok.NonNull;
import lombok.Value;

@Value
public class AssignmentPair {
  @NonNull IntRange section1;
  @NonNull IntRange section2;


  public static @NonNull AssignmentPair parse(@NonNull String line) {
    final var idx = line.indexOf(",");
    return new AssignmentPair(IntRange.day4Parser(line.substring(0,idx)), IntRange.day4Parser(line.substring(idx+1)));
  }

  public boolean hasSectionFullyContainedInOther() {
    return section2.contains(section1) || section1.contains(section2);
  }

  public boolean hasSectionsOverlapping() {
    return section1.overlapsWith(section2);
  }
}
