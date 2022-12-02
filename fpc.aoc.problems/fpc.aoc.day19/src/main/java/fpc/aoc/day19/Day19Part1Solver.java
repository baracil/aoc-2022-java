package fpc.aoc.day19;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import fpc.aoc.day19.struct.Match;
import fpc.aoc.day19.struct.Report;
import fpc.aoc.day19.struct.ReportMerger;
import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Day19Part1Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Report> input) {
        final var report = ReportMerger.merge(input);
        return report.getNbBeacons();
    }

}
