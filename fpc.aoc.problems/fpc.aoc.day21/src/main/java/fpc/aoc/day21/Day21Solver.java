package fpc.aoc.day21;

import com.google.common.collect.ImmutableMap;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class Day21Solver<T> extends SmartSolver<Group,Long> {

    private final MonkeyEvaluator<T> evaluator;

    @Override
    protected @NonNull Converter<Group> getConverter()
    {
        return s -> s.map(Monkey::parse)
                .collect(Collectors.collectingAndThen(
                        ImmutableMap.toImmutableMap(Monkey::name, m -> m),Group::new));
    }

    @Override
    public @NonNull Long solve(@NonNull Group group) {
        final var rootValue = group.getRootValue(evaluator);
        return finalize(rootValue);
    }

    protected abstract Long finalize(T rootResult);
}
