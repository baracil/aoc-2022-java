package fpc.aoc.day8;

import fpc.aoc.day8.struct.WiringInfo;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day8Solver extends SmartSolver<Stream<WiringInfo<String>>,Long> {

    @Override
    protected @NonNull Converter<Stream<WiringInfo<String>>> getConverter() {
        return s -> s.map(WiringInfo::parse);
    }
}
