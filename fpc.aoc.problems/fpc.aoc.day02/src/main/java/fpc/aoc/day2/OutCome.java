package fpc.aoc.day2;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OutCome {
  LOSS(0),
  WIN(6),
  DRAW(3),
  ;
  private final int score;

  public @NonNull Shape getCorrespondingShape(Shape adversaryShape) {
    return switch (this) {
      case DRAW -> adversaryShape;
      case WIN -> adversaryShape.getBetter();
      case LOSS -> adversaryShape.getWorse();
    };
  }
}
