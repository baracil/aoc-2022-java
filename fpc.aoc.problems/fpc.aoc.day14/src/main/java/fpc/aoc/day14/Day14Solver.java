package fpc.aoc.day14;

import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;

@RequiredArgsConstructor
public abstract class Day14Solver extends SmartSolver<Cave,Long> {

    @Override
    protected @NonNull Converter<Cave> getConverter() {
        return s -> s.map(Path::parse)
            .flatMap(Path::positions)
            .collect(CaveAggregator.CAVE_COLLECTOR);
    }

    private final @NonNull Predicate<Cave> dropper;

    @Override
    public @NonNull Long solve(@NonNull Cave input) {
        long nb = 0;
        while (dropper.test(input)) {
            nb++;
        }
        return nb;
    }




    private static class CaveAggregator {

        public static final Collector<Position,?,Cave> CAVE_COLLECTOR = Collector.of(
            CaveAggregator::new,
            CaveAggregator::addPosition,
            CaveAggregator::merge,
            CaveAggregator::build
        );

        private final Map<Position,Type> types = new HashMap<>();


        public void addPosition(@NonNull Position position) {
            types.put(position,Type.ROCK);
        }
        public CaveAggregator merge(@NonNull CaveAggregator aggregator) {
            types.putAll(aggregator.types);
            return this;
        }
        public Cave build() {
            return new Cave(types);
        }
    }
}
