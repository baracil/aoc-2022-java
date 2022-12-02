package fpc.aoc.day14;

import fpc.aoc.day14.struct.Input;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Collector;
import java.util.stream.Stream;

public abstract class Day14Solver extends SmartSolver<Input,String> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return s -> s.collect(Input.COLLECTOR);
    }


}
