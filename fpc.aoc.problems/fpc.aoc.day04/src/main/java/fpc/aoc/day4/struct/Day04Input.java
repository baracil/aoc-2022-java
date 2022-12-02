package fpc.aoc.day4.struct;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@RequiredArgsConstructor
public class Day04Input {

    private final ImmutableList<Integer> numbers;
    private final ImmutableList<Grid> grids;
    @Getter
    private final GridState gridState;


    public Optional<Day04Input> playOneRoundPart1() {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        final var number = this.numbers.get(0);
        final var numbers = this.numbers.stream().skip(1).collect(ImmutableList.toImmutableList());

        final var grids = this.grids.stream()
                                    .map(g -> g.pushOneNumber(number))
                                    .collect(ImmutableList.toImmutableList());

        final var state = grids.stream()
                               .map(Grid::state)
                               .filter(s -> s instanceof GridState.Winning)
                               .findFirst()
                               .orElse(gridState);

        return Optional.of(new Day04Input(numbers, grids, state));
    }

    public Optional<Day04Input> playOneRoundPart2() {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        final var number = this.numbers.get(0);
        final var numbers = this.numbers.stream().skip(1).collect(ImmutableList.toImmutableList());

        final var grids = this.grids.stream()
                                    .filter(g -> g.state() instanceof GridState.NotWinning)
                                    .map(g -> g.pushOneNumber(number))
                                    .collect(ImmutableList.toImmutableList());

        final var state = grids.stream()
                               .map(Grid::state)
                .reduce((first,second) -> second instanceof GridState.Winning ? second:first).orElse(gridState);

        return Optional.of(new Day04Input(numbers, grids, state));
    }


    public static Collector<String, ?, Day04Input> COLLECTOR = Collector.of(Agglomerator::new,
            Agglomerator::accumulate,
            Agglomerator::combiner,
            Agglomerator::finisher
    );


    private static class Agglomerator {

        private ImmutableList<Integer> numbers;
        private List<Grid> grids = new ArrayList<>();
        private List<String> gridRows = new ArrayList<>();

        public void accumulate(@NonNull String line) {
            if (line.isEmpty()) {
                buildGrid();
                gridRows.clear();
            } else if (numbers == null) {
                numbers = Arrays.stream(line.split(","))
                                .map(Integer::parseInt)
                                .collect(ImmutableList.toImmutableList());
            } else {
                gridRows.add(line);
            }
        }

        public Agglomerator combiner(@NonNull Agglomerator agglomerator) {
            throw new UnsupportedOperationException();
        }

        public Day04Input finisher() {
            buildGrid();
            return new Day04Input(numbers, ImmutableList.copyOf(grids), new GridState.NotWinning());
        }

        private void buildGrid() {
            if (gridRows.isEmpty()) {
                return;
            }
            final var grid = Grid.from(gridRows);
            grids.add(grid);
        }
    }
}
