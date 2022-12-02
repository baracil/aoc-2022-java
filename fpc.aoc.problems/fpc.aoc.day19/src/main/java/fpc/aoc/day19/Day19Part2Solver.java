package fpc.aoc.day19;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.IntPair;
import fpc.aoc.common.Pair;
import fpc.aoc.day19.struct.Match;
import fpc.aoc.day19.struct.Report;
import fpc.aoc.day19.struct.ReportMerger;
import lombok.NonNull;

import java.util.Optional;

public class Day19Part2Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Report> input) {
        final var report = ReportMerger.merge(input);

        final var offsets = input.stream()
                                 .map(report::findMatching)
                                 .flatMap(Optional::stream)
                                 .map(Match::offset)
                                 .collect(ImmutableList.toImmutableList());

        return IntPair.cartesian(offsets.size())
                      .filter(p -> p.first() < p.second())
                      .map(p -> Pair.extract(offsets, p))
                      .mapToInt(pair -> pair.first().manhattan(pair.second()))
                      .max().orElse(0);
    }
}
