package fpc.aoc.day6;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day6Test {


    public static Stream<Arguments> testDay6Part1() {
        return Stream.of(
            Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz",5),
            Arguments.of("nppdvjthqldpwncqszvftbrmjlhg",6),
            Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",10),
            Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw",11)
        );
    }
    public static Stream<Arguments> testDay6Part2() {
        return Stream.of(
            Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb",19),
            Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz",23),
            Arguments.of("nppdvjthqldpwncqszvftbrmjlhg",23),
            Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",29),
            Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw",26)
        );
    }

    @ParameterizedTest
    @MethodSource("testDay6Part1")
    public void testPart1(@NonNull String line, int expected) {
        final var actual = new Day6Part1Solver().createProblem(line).solve();
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("testDay6Part2")
    public void testPart2(@NonNull String line, int expected) {
        final var actual = new Day6Part2Solver().createProblem(line).solve();
        Assertions.assertEquals(expected,actual);
    }


}
