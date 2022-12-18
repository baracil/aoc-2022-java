package fpc.aoc.day18;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(of = {"center"})
public class Face {

  Cube cube;
  Point center;

  @Override
  public String toString() {
    return "Face{" + center + '}';
  }
}
