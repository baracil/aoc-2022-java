package fpc.aoc.day9;

import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.stream.IntStream;

public class Rope {

  private final @NonNull Knot[] knots;

  public Rope(int nbKnots) {
    knots = IntStream.range(0,nbKnots).mapToObj(i -> new Knot(Position.of(0,0))).toArray(Knot[]::new);
  }

  public void moveHead(@NonNull Displacement displacement) {
    knots[0].displaced(displacement);
    for (int i = 1; i < knots.length ; i++) {
      knots[i].follow(knots[i-1]);
    }
  }

  public Position tailPosition() {
    return knots[knots.length-1].position();
  }

}
