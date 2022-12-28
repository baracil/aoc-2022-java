package fpc.aoc.day20;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day20Solver extends SmartSolver<Chain,Long> {

    private final long key;
    private final int nbCycles;

    @Override
    protected @NonNull Converter<Chain> getConverter() {
        return Converter.TO_ARRAY_OF_INT.andThen(v -> new Chain(v,key));
    }

    @Override
    public @NonNull Long solve(@NonNull Chain input) {
        for (int i = 0; i < nbCycles; i++) {
            input.performOneCycle();
        }
        return input.getCoordinate();
    }
}
