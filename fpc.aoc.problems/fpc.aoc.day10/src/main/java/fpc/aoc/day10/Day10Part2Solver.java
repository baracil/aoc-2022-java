package fpc.aoc.day10;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day10Part2Solver extends Day10Solver<String> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull ImmutableList<Command> input) {
        final var videoSystem = new VideoSystem();

        videoSystem.execute(new CommandProvider(input));
        return videoSystem.dumpDisplay();
    }
}
