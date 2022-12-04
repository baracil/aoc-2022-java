package fpc.oac.day4;

import fpc.aoc.day4.Day4Part1Solver;
import fpc.aoc.day4.Day4Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {

    public static final String TEST_INPUT = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
            """;

    @Test
    public void testPart1() {
        final var actual = new Day4Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(2,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day4Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(4,actual);
    }


}
