package fpc.aoc.day7;

import fpc.aoc.common.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day7Test {

    public static final String TEST_INPUT = """
            """;

    @Test
    public void testPart1() {
        final var actual = new Day7Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day7Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }


}
