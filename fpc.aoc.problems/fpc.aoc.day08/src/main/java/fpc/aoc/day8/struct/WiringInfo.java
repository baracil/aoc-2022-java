package fpc.aoc.day8.struct;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

public record WiringInfo<T>(ImmutableList<T> numbers,
                            ImmutableList<T> digits) {

    public static @NonNull WiringInfo<String> parse(@NonNull String line) {
        final var tokens = line.split("\\|");
        final var numbers = ImmutableList.copyOf(tokens[0].trim().split(" "));
        final var digits = ImmutableList.copyOf(tokens[1].trim().split(" "));
        return new WiringInfo<>(numbers, digits);
    }


    public static int display(@NonNull WiringInfo<Integer> wiringInfo) {
        return wiringInfo.digits().stream().reduce(0, (n, d) -> n * 10 + d);
    }

}
