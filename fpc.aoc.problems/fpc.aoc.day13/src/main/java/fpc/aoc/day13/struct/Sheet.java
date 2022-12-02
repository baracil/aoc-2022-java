package fpc.aoc.day13.struct;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Sheet {

    private final ImmutableSet<Dot> dots;

    public @NonNull Sheet fold(@NonNull Fold fold) {
        final var operator = fold.operator();

        return dots.stream()
                   .map(operator)
                   .collect(COLLECTOR);
    }

    private final Collector<Dot,?,Sheet> COLLECTOR = Collectors.collectingAndThen(ImmutableSet.toImmutableSet(), Sheet::new);

    public int getNumberOfDots() {
        return dots.size();
    }

    public String toDisplay() {
        final int xmax = dots.stream().mapToInt(Dot::x).max().orElse(0);
        final int ymax = dots.stream().mapToInt(Dot::y).max().orElse(0);

        final StringBuilder sb = new StringBuilder();
        for (int y = 0; y <= ymax; y++) {
            sb.append(System.lineSeparator());
            for (int x = 0; x <= xmax; x++) {
                if (dots.contains(Dot.with(x,y))) {
                    sb.append("█");
                } else {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}
