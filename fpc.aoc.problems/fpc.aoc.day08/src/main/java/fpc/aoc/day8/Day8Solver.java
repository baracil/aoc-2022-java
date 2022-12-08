package fpc.aoc.day8;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day8Solver extends SmartSolver<Forest,Long> {

    @Override
    protected @NonNull Converter<Forest> getConverter() {
        return s -> new Forest(ArrayOfChar.from(s,' '));
    }
}
