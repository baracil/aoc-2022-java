package fpc.aoc.day3;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Group {

  private final ImmutableList<Compartment> compartments;

  public int getCommonItem() {
    return IntStream.range(0, 52)
        .filter(this::isInAllCompartments)
        .findAny()
        .orElseThrow(() -> new AOCException("No common item in group"));
  }

  private boolean isInAllCompartments(int item) {
    for (Compartment compartment : compartments) {
      if (!compartment.contains(item)) {
        return false;
      }
    }
    return true;
  }

}
