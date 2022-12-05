package fpc.aoc.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Input5,String> {

    @Override
    protected @NonNull Converter<Input5> getConverter() {
        return s -> s.collect(Input5.COLLECTOR);
    }

    private final CrateMover crateMover;

    @Override
    public @NonNull String solve(@NonNull Input5 input) {
        final var stacks = input.stacks();
        input.steps().forEach(p -> crateMover.performProcedureStep(stacks,p));
        return stacks.listTopOfStacks();
    }
}
