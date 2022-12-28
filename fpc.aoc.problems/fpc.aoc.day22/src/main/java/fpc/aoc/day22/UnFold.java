package fpc.aoc.day22;

import fpc.aoc.common.Position;

public interface UnFold {

  Move findNext(Position position, Orientation orientation);

}
