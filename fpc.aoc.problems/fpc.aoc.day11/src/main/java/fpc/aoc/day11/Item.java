package fpc.aoc.day11;

public record Item(long worryLevel) {

  @Override
  public String toString() {
    return worryLevel+"";
  }
}
