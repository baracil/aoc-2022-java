package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.LongUnaryOperator;

@RequiredArgsConstructor
public abstract class Day11Solver extends SmartSolver<MonkeyGame,Long> {


    @Override
    protected @NonNull Converter<MonkeyGame> getConverter() {
        return s -> s.collect(ParsedMonkeyAgg.collect(this::createPostOperation));
    }


    @Override
    public @NonNull Long solve(@NonNull MonkeyGame input) {
        for (int i = 0; i < getNumberOfTurns(); i++) {
            input.performOneTurn();
        }
        return input.getMonkeyBusiness();
    }

    protected abstract int getNumberOfTurns();

    protected abstract LongUnaryOperator createPostOperation(@NonNull ImmutableList<ParsedMonkey> parsedMonkeys);
}
