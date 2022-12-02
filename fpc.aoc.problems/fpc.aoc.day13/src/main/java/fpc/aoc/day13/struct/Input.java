package fpc.aoc.day13.struct;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collector;

@RequiredArgsConstructor
@Getter
public class Input {

    private final Sheet sheet;

    private final ImmutableList<Fold> folds;


    public static Collector<String, ?, Input> COLLECTOR = Collector.of(
            Acc::new,
            Acc::pushLine,
            Acc::combine,
            Acc::build
            );

    @NoArgsConstructor
    private static final class Acc {

        private final ImmutableSet.Builder<Dot> dots = ImmutableSet.builder();
        private final ImmutableList.Builder<Fold> folds = ImmutableList.builder();

        public boolean inDots = true;

        public @NonNull Input build() {
            return new Input(new Sheet(dots.build()), folds.build());
        }

        public @NonNull Acc combine(@NonNull Acc other) {
            throw new UnsupportedOperationException();
        }

        public void pushLine(@NonNull String line) {
            if (line.isBlank()) {
                inDots = false;
                return;
            }

            if (inDots) {
                dots.add(Dot.parse(line));
            } else {
                folds.add(Fold.parse(line));
            }
        }

    }
}
