package fpc.aoc.day22;

import com.google.common.collect.ImmutableMap;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public abstract class BaseNavigationFactory {

  protected final ArrayOfChar map;

  public Navigation create() {
    final var gridHelper = GridHelper.create(map.width(), map.height());
    final var pos = gridHelper.allPositionsOnGrid()
        .filter(this::isNotSpace)
        .map(this::createPos)
        .collect(ImmutableMap.toImmutableMap(Navigation.Pos::position, Function.identity()));

    return new Navigation(findStart(),pos);
  }

  protected abstract Move findNext(Position position, Orientation orientation);

  private Navigation.Pos createPos(Position position) {
    final Function<Orientation, Move> findNext = d -> findNext(position, d);
    final var mapPos = Arrays.stream(Orientation.values()).collect(ImmutableMap.toImmutableMap(d -> d, findNext));
    return new Navigation.Pos(position, mapPos);
  }


  private Position findStart() {
    return IntStream.range(0, map.width()).filter(x -> map.get(x, 0) == '.').mapToObj(x -> new Position(x, 0)).findFirst().orElseThrow();
  }

  protected boolean isNotSpace(Position position) {
    return map.get(position) != ' ';
  }
}
