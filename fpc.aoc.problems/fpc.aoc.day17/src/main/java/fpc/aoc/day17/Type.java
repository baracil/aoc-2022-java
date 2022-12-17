package fpc.aoc.day17;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {
  EMPTY(true),
  ROCK(false),
  WALL(false),
  ;
  @Getter
  private final boolean empty;
}
