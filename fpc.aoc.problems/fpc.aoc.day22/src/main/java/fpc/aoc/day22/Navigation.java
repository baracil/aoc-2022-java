package fpc.aoc.day22;

import com.google.common.collect.ImmutableMap;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Navigation {

    @Getter
    private final Position start;
    private final ImmutableMap<Position, Pos> pos;

    public Position next(Position position, Orientation orientation) {
        return pos.get(position).next(orientation);
    }


    public static Navigation create(ArrayOfChar map) {
        final var gridHelper = GridHelper.create(map.width(),map.height());
        final var pos = gridHelper.allPositionsOnGrid().filter(p -> map.get(p) != ' ').map(p -> createPos(map,p)).collect(ImmutableMap.toImmutableMap(Pos::position, p -> p));
        Position start = IntStream.range(0, map.width()).filter(x -> map.get(x, 0) == '.').mapToObj(x -> new Position(x, 0)).findFirst().orElseThrow();
        return new Navigation(start,pos);
    }

    private static Pos createPos(ArrayOfChar map, Position position) {
        final Function<Orientation,Position> findNext = d -> findNext(map,position,d);
        final var mapPos = Arrays.stream(Orientation.values()).collect(ImmutableMap.toImmutableMap(d -> d, findNext));
        return new Pos(position, mapPos);
    }

    private static Position findNext(ArrayOfChar map, Position position, Orientation orientation) {
        var p = position;
        do {
            p = p.displaced(orientation.displacement()).wrap(map.width(), map.height());
            if (map.get(p) != ' ') {
                return p;
            }
        } while (true);
    }

    @Value
    public static class Pos {
        Position position;
        ImmutableMap<Orientation,Position> neighbours;

        public Position next(Orientation orientation) {
            return neighbours.get(orientation);
        }
    }
}
