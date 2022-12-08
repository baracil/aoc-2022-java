package fpc.aoc.day8;

import fpc.aoc.common.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day8Test {

    public static final String TEST_INPUT = """
            """;

    @Test
    public void testPart1() {
        final var actual = new Day8Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day8Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }


}
