package fpc.aoc.day12;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day12Solver extends SmartSolver<ArrayOfChar,Integer> {

    @Override
    protected @NonNull Converter<ArrayOfChar> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR;
    }

    private final PathInfo pathInfo;




    @Override
    public @NonNull Integer solve(@NonNull ArrayOfChar input) {
        final var pathFinder = new PathFinder(input,pathInfo);
        final var path = pathFinder.findShortestPath();
        return path.nbSteps();

    }

}
