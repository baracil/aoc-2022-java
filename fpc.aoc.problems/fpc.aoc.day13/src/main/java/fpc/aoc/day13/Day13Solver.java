package fpc.aoc.day13;

import fpc.aoc.day13.struct.Input;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day13Solver extends SmartSolver<Input,String> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return Converter.IDENTITY.andThen(s -> s.collect(Input.COLLECTOR));
    }


}
