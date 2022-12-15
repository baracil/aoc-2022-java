package fpc.aoc.day15;

import com.google.common.collect.ImmutableList;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Collectors;

public abstract class Day15Solver extends SmartSolver<Report,Long> {

    @Override
    protected @NonNull Converter<Report> getConverter() {
        return s -> s.map(SensorReport::parse)
            .collect(Collectors.collectingAndThen(ImmutableList.toImmutableList(),Report::new));
    }
}
