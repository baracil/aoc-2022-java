package fpc.aoc.day20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day20Test {

    public static final String TEST_INPUT = """
            1
            2
            -3
            3
            -2
            0
            4
            """;

    @Test
    public void testPart1() {
        final var actual = new Day20Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(3,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day20Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(1623178306,actual);
    }


}
