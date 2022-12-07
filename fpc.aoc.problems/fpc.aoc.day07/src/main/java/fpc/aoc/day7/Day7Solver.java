package fpc.aoc.day7;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day7Solver extends SmartSolver<FileSystem,Integer> {

    @Override
    protected @NonNull Converter<FileSystem> getConverter() {
        return stream -> stream.collect(FileSystemCollector.COLLECTOR);
    }
}
