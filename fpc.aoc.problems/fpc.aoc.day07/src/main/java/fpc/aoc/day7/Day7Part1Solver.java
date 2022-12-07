package fpc.aoc.day7;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day7Part1Solver extends Day7Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day7Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull FileSystem fileSystem) {

        return fileSystem.streamDirectories()
            .mapToInt(File.Folder::size)
            .filter(size -> size <= 100000)
            .sum();
    }
}
