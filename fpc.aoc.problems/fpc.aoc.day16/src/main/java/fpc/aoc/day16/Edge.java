package fpc.aoc.day16;

import lombok.NonNull;
import lombok.Value;

@Value
public class Edge {
  @NonNull String valve1;
  @NonNull String valve2;

  public Edge(@NonNull String valve1, @NonNull String valve2) {
    if (valve1.compareTo(valve2) > 0) {
      this.valve1 = valve2;
      this.valve2 = valve1;
    } else {
      this.valve1 = valve1;
      this.valve2 = valve2;
    }
  }
}
