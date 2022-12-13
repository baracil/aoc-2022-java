package fpc.aoc.day13;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day13Part2Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part2Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<PairOfItem> input) {
        final var divider1 = ItemParser.parse("[[2]]");
        final var divider2 = ItemParser.parse("[[6]]");
        final var sortedItems = Stream.concat(
                input.stream().flatMap(PairOfItem::items),
                Stream.of(divider1, divider2)
            ).sorted()
            .toList();

        return IntStream.range(0, sortedItems.size())
            .filter(i -> sortedItems.get(i) == divider1 || sortedItems.get(i) == divider2)
            .map(i -> i+1)
            .reduce(1, (a, b) -> a * b);
    }
}
