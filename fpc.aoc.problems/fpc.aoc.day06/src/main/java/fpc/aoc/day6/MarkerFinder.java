package fpc.aoc.day6;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Optional;

public class MarkerFinder {

  private final int dataMarkerLength;
  private final int[] current;
  private final int[] counts;
  private int idx;
  private int nbDistinct;

  public MarkerFinder(int dataMarkerLength) {
    this.dataMarkerLength = dataMarkerLength;
    this.current = new int[dataMarkerLength];
    this.counts = new int[26];
    Arrays.fill(this.current,-1);
  }

  public @NonNull Optional<Integer> handleChar(char c) {
    final int countIndexToIncrease = c -'a';
    final int countIndexToDecrease = this.current[idx%dataMarkerLength];
    this.current[idx%dataMarkerLength] = countIndexToIncrease;

    idx++;

    if (countIndexToDecrease != countIndexToIncrease) {
      decrease(countIndexToDecrease);
      increase(countIndexToIncrease);
    }

    return nbDistinct == dataMarkerLength? Optional.of(idx):Optional.empty();
  }

  private void decrease(int countIndex) {
    if (countIndex<0) {
      return;
    }
    final var currentCount = this.counts[countIndex];
    this.counts[countIndex] = currentCount-1;
    this.handleModification(currentCount,currentCount-1);
  }

  private void increase(int countIndex) {
    final var currentCount = this.counts[countIndex];
    this.counts[countIndex] = currentCount+1;
    this.handleModification(currentCount,currentCount+1);
  }

  private void handleModification(int oldCount, int newCount) {
    if (oldCount == 1) {
      nbDistinct--;
    }
    if (newCount == 1) {
      nbDistinct++;
    }
  }
}
