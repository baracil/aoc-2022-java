package fpc.aoc.day16;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "opened")
public class ValveState {

  private final ValveHelper valveHelper;
  @Getter
  private final int opened;

  public @NonNull ValveState open(@NonNull String valve) {
    return new ValveState(valveHelper, valveHelper.withOpened(valve, opened));
  }

  public boolean areAllOpened() {
    return valveHelper.areAllOpened(opened);
  }

  public boolean isOpen(String valve) {
    return valveHelper.isOpened(valve, opened);
  }

  public ValveState open(String valve1, String valve2) {
    return new ValveState(valveHelper, valveHelper.withOpened(valve1,valve2, opened));
  }
}
