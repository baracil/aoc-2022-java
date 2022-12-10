package fpc.aoc.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day9Test {

    public static final String TEST_INPUT = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
        """;
    public static final String TEST_INPUT2 = """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
        """;

    @Test
    public void testPart1() {
        final var actual = new Day9Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(13,actual);
    }

    @Test
    public void test1Part2() {
        final var actual = new Day9Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(1,actual);
    }

    @Test
    public void test2Part2() {
        final var actual = new Day9Part2Solver().createProblem(TEST_INPUT2).solve();
        Assertions.assertEquals(36,actual);
    }


}
