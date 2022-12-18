package fpc.aoc.day16;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.day16._private.SimpleValveHelper;
import lombok.NonNull;

public interface ValveHelper {

  int withOpened(String valve, int opened);

  int withOpened(String valve1, String value2, int opened);

  boolean areAllOpened(int opened);

  boolean isOpened(String valve, int opened);

  @NonNull ValveState allClosedState();

  static @NonNull ValveHelper create(ImmutableSet<String> usefulValves) {
    return new SimpleValveHelper(usefulValves);
  }

}
