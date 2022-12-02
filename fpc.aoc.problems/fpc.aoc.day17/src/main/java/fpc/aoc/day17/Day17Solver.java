package fpc.aoc.day17;

import fpc.aoc.day17.struct.Target;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day17Solver extends SmartSolver<Target,Long> {

    @Override
    protected @NonNull Converter<Target> getConverter() {
        return Converter.FIRST_LINE.andThen(Target::parse);
    }
}
