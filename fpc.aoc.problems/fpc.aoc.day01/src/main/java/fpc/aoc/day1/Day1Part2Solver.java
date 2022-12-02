package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Day1Part2Solver extends Day1Solver {

    public static AOCProblem<?> provider() {
        return new Day1Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull LongStream input) {
        final var top = new Top(3);
        input.forEach(top::handle);
        return top.sum();
    }

    private static class Top {
        private final long[] top;

        public long sum() {
            return Arrays.stream(top).sum();
        }

        public Top(int n) {
            this.top = new long[n];
            Arrays.fill(this.top,-1);
        }


        public void handle(long l) {
            if (l <= top[0]) {
                return;
            }

            boolean set = false;
            for (int i = 1;i< top.length;i++) {
                if (l>top[i]) {
                    top[i-1] = top[i];
                } else {
                    top[i-1] = l;
                    set= true;
                    break;
                }
            }
            if (!set) {
                top[top.length-1] = l;
            }
        }
    }
}
