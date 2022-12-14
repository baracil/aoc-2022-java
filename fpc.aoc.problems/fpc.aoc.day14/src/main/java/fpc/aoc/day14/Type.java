package fpc.aoc.day14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {
  ROCK('█'),
  SAND('o'),
  EMPTY('.'),
  ;

  @Getter
  private final char chr;
}
