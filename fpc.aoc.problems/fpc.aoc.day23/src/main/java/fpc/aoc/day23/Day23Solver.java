package fpc.aoc.day23;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day23Solver extends SmartSolver<Elves,Integer> {

    @Override
    protected @NonNull Converter<Elves> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR
            .andThen(this::getElfPositions)
            .andThen(s -> s.collect(ImmutableSet.toImmutableSet()))
            .andThen(Elves::new);
    }

    private Stream<Position> getElfPositions(ArrayOfChar arrayOfChar) {
        final var helper = GridHelper.create(arrayOfChar.width(),arrayOfChar.height());
        return helper.allPositionsOnGrid()
            .filter(p -> arrayOfChar.get(p) == '#');
    }
}
