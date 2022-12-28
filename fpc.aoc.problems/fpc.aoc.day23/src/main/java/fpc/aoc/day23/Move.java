package fpc.aoc.day23;

import fpc.aoc.common.Displacement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Move {
  SE(Displacement.SE,1<<0),
  S(Displacement.S,1<<1),
  SW(Displacement.SW,1<<2),
  E(Displacement.E, 1<<3),
  W(Displacement.W,1<<5),
  NE(Displacement.NE,1<<6),
  N(Displacement.N,1<<7),
  NW(Displacement.NW,1<<8),
  ;
  @Getter
  private final Displacement displacement;
  @Getter
  private final int mask;
}
