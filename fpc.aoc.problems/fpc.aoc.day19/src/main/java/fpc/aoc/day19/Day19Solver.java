package fpc.aoc.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day19Solver extends SmartSolver<Stream<BluePrint>,Long> {

    @Override
    protected @NonNull Converter<Stream<BluePrint>> getConverter() {
        return s -> s.map(BluePrint::parse);
    }



}
