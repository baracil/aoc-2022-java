package fpc.aoc.day12;

import fpc.aoc.day12.struct.Connection;
import fpc.aoc.day12.struct.Graph;
import fpc.aoc.day12.struct.PathCounter;
import fpc.aoc.day12.struct.RecursiveMode;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day12Solver extends SmartSolver<Graph,Long> {

    @Override
    protected @NonNull Converter<Graph> getConverter() {
        return Converter.IDENTITY
                .andThen(s -> s.map(Connection::parse).collect(Graph.COLLECTOR));
    }

    @Override
    public @NonNull Long solve(@NonNull Graph graph) {
        return PathCounter.count(graph,getRecursiveMode());
    }

    protected abstract RecursiveMode getRecursiveMode();
}
