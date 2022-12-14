package fpc.aoc.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14Test {

    public static final String TEST_INPUT = """
            498,4 -> 498,6 -> 496,6
            503,4 -> 502,4 -> 502,9 -> 494,9
            """;

    @Test
    public void testPart1() {
        final var actual = new Day14Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(24,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day14Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(93,actual);
    }


}
