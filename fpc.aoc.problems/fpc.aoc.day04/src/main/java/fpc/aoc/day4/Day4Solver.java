package fpc.aoc.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day4Solver extends SmartSolver<Stream<AssignmentPair>,Integer> {

    @Override
    protected @NonNull Converter<Stream<AssignmentPair>> getConverter() {
        return s -> s.map(AssignmentPair::parse);
    }
}
