package fpc.aoc.day22;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Map {
    private final ArrayOfChar map;
    private final Navigation navigation;

    public Map(ArrayOfChar map) {
        this.map = map;
        this.navigation = Navigation.create(map);
    }

    public Player start() {
        return new Player(navigation.start(),Orientation.RIGHT);
    }

    public Position next(Position position, Orientation orientation) {
        return navigation.next(position,orientation);
    }

    public boolean isWall(Position position) {
        return map.get(position) == '#';
    }
}
