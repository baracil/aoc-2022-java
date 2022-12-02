package fpc.aoc.day19.struct;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.Pair;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class ReportMerger {

    public static @NonNull Report merge(@NonNull ImmutableList<Report> reports) {
        return new ReportMerger(reports).merge();
    }

    private final Set<Report> reports;

    private ReportMerger(ImmutableList<Report> reports) {
        this.reports = new HashSet<>(reports);
    }

    private @NonNull Report merge() {
        while (reports.size()>1) {
            final var mergeResult = findMatch().orElse(null);
            if (mergeResult == null) {
                break;
            }
            final var r1 = mergeResult.report1();
            final var r2 = mergeResult.report2();
            final var merged = r1.merge(r2.applyTransformation(mergeResult.match));

            reports.remove(r1);
            reports.remove(r2);
            reports.add(merged);
        }

        return reports.stream().findFirst().orElseThrow(() -> new AOCException("Cannot merge all reports"));
    }

    private Optional<MergeResult> findMatch() {
        return allPairs().map(this::match)
                         .flatMap(Optional::stream)
                         .findFirst();
    }

    private Stream<Pair<Report,Report>> allPairs() {
        return reports.stream()
                      .flatMap(r1 -> reports.stream().map(r2 -> Pair.of(r1, r2)))
                      .filter(p -> p.first() != p.second());
    }

    private @NonNull Optional<MergeResult> match(@NonNull Pair<Report,Report> reports) {
        final Report r1 = reports.first();
        final Report r2 = reports.second();
        return r1.findMatching(r2).filter(m -> m.nbMatch() >=12).map(m -> new MergeResult(r1,r2, m));
    }


    private record MergeResult(@NonNull Report report1, @NonNull Report report2, @NonNull Match match) {}

}
