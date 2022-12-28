package fpc.aoc.day22;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.Value;

@Value
public class Player {

    private final Position position;
    private final Orientation orientation;

    public Player move(Map map, int nbSteps) {
        var current = position;
        for (int i = 0; i < nbSteps; i++) {
            final var next = map.next(current, orientation);
            if (map.isWall(next)) {
                break;
            }
            current = next;
        }
        return new Player(current,orientation);
    }

    public Player rotateR() {
        return new Player(position,orientation.clockwise());
    }
    public Player rotateL() {
        return new Player(position,orientation.antiClockwise());
    }

    public int getValue() {
        final var row = 1000*(position.y()+1);
        final var col = 4*(position.x()+1);
        final var facing = orientation.value();
        return row+col+facing;
    }
}
