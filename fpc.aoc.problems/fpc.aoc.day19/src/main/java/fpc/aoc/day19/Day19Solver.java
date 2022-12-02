package fpc.aoc.day19;

import com.google.common.collect.ImmutableList;
import fpc.aoc.day19.struct.Report;
import fpc.aoc.day19.struct.ReportCollector;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day19Solver extends SmartSolver<ImmutableList<Report>,Integer> {

    @Override
    protected @NonNull Converter<ImmutableList<Report>> getConverter() {
        return s -> s.collect(ReportCollector.COLLECTOR);
    }
}
