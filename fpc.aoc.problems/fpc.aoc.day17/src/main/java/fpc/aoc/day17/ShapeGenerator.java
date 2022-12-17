package fpc.aoc.day17;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

public class ShapeGenerator {

  public final ImmutableList<ShapeType> shapes = ImmutableList.of(
      ShapeType.HBAR, ShapeType.CROSS, ShapeType.CORNER, ShapeType.VBAR, ShapeType.SQUARE
  );

  public @NonNull ShapeType getShape(int index) {
    return shapes.get(index % shapes.size());
  }
}
