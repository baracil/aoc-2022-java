package fpc.aoc.day10;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.IntStream;

public class Day10Part1Solver extends Day10Solver<Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part1Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Command> input) {
        final var videoSystem = new VideoSystem();

        videoSystem.execute(new CommandProvider(input));

        return IntStream.iterate(20, i -> i <= 220, i -> i + 40)
            .map(videoSystem.signalStrength()::get)
            .sum();

    }
}
