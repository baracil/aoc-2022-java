package fpc.aoc.day18;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum Disp {
  LEFT(-1, 0, 0),
  RIGHT(1, 0, 0),
  TOP(0, 0, 1),
  BOTTOM(0, 0, -1),
  FRONT(0, 1, 0),
  BACK(0, -1, 0),
  ;

  private final int dx;
  private final int dy;
  private final int dz;


  public static Stream<Disp> allValues() {
    return Holder.VALUES.stream();
  }

  private static class Holder {
    private static final ImmutableList<Disp> VALUES = ImmutableList.of(LEFT,BOTTOM,BACK,RIGHT,TOP,FRONT);
  }

}
