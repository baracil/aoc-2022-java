package fpc.aoc.common;

import lombok.NonNull;

public record IntRange(int inf, int sup) {


  public boolean contains(@NonNull IntRange other) {
    return this.inf <= other.inf && this.sup>=other.sup;
  }

  public boolean overlapsWith(@NonNull IntRange other) {
    return !(this.inf > other.sup || this.sup < other.inf);
  }

  public static IntRange day4Parser(@NonNull String line) {
    final var idx = line.indexOf("-");

    final var section1 = Integer.parseInt(line.substring(0, idx));
    final var section2 = Integer.parseInt(line.substring(idx + 1));
    return new IntRange(section1, section2);
  }

}
