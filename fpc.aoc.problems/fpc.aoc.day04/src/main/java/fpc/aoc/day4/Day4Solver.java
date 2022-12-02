package fpc.aoc.day4;

import fpc.aoc.day4.struct.Day04Input;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day4Solver extends SmartSolver<Day04Input,String> {

    @Override
    protected @NonNull Converter<Day04Input> getConverter() {
        return s -> s.collect(Day04Input.COLLECTOR);
    }
}
