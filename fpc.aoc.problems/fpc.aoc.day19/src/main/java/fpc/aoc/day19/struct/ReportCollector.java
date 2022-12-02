package fpc.aoc.day19.struct;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.stream.Collector;

public class ReportCollector {

    public static final Collector<String,ReportCollector, ImmutableList<Report>> COLLECTOR = Collector.of(
            ReportCollector::new,
            ReportCollector::accumulate,
            ReportCollector::combine,
            ReportCollector::build
    );

    private Report.ReportBuilder builder = null;
    private ImmutableList.Builder<Report> reports = ImmutableList.builder();

    public void accumulate(@NonNull String line) {
        if (line.startsWith("---")) {
            this.finishBuilderIfAny();
            this.builder = new Report.ReportBuilder();
        } else if (!line.isBlank()) {
            builder.beacon(Vector.parse(line));
        }
    }


    public ReportCollector combine(@NonNull ReportCollector other) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<Report> build() {
        this.finishBuilderIfAny();
        return reports.build();
    }

    private void finishBuilderIfAny() {
        if (builder != null) {
            reports.add(builder.build());
        }
        builder = null;
    }

}
