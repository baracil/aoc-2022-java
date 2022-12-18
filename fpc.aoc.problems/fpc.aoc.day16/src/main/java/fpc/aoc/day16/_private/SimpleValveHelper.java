package fpc.aoc.day16._private;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import fpc.aoc.day16.ValveHelper;
import fpc.aoc.day16.ValveState;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SimpleValveHelper implements ValveHelper {

  private final ImmutableMap<String, Integer> masks;
  private final String[] valveNames;
  private final int allOpened;

  public SimpleValveHelper(@NonNull ImmutableSet<String> valveNames) {
    this.valveNames = valveNames.toArray(String[]::new);
    this.masks = IntStream.range(0, valveNames.size())
        .boxed().collect(ImmutableMap.toImmutableMap(i -> this.valveNames[i], i -> (1 << i)));

    allOpened = masks.values().stream().reduce(0,(a,b) -> a|b);

  }

  @Override
  public boolean isOpened(String valve, int opened) {
    final var m = masks.get(valve);
    if (m == null) {
      return true;
    }
    return (opened & m) != 0;
  }

  public boolean areAllOpened(int opened) {
    return this.allOpened == opened;
  }

  @Override
  public @NonNull ValveState allClosedState() {
    return new ValveState(this, 0);
  }

  @Override
  public int withOpened(String valve, int opened) {
    final var m = masks.get(valve);
    return opened | m;
  }

  @Override
  public int withOpened(String valve1, String valve2, int opened) {
    final var m1 = masks.get(valve1);
    final var m2 = masks.get(valve2);
    return opened | (m1 | m2);
  }
}
