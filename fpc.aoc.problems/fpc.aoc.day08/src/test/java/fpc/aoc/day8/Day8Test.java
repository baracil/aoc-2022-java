package fpc.aoc.day8;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day8Test {

    public static final String TEST_INPUT = """
        30373
        25512
        65332
        33549
        35390
        """;

    public static Stream<Arguments> scores() {
        return Stream.of(
            Arguments.of(Position.of(2,3), Displacement.S,1),
            Arguments.of(Position.of(2,3), Displacement.N,2),
            Arguments.of(Position.of(2,3), Displacement.E,2),
            Arguments.of(Position.of(2,3), Displacement.W,2)
        );
    }

    @Test
    public void testPart1() {
        final var actual = new Day8Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(21,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day8Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(8,actual);
    }

    @ParameterizedTest
    @MethodSource("scores")
    public void testPart2ScenicScore(@NonNull Position position, @NonNull Displacement displacement, long expectedScore) {
        final var forest = new Forest(ArrayOfChar.from(TEST_INPUT,' '));
        final var actual = forest.scenicScoreInOneDirection(position,displacement);
        Assertions.assertEquals(expectedScore,actual);
    }
}
