package fpc.aoc.day24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day24Test {

    public static final String TEST_INPUT = """
        #.######
        #>>.<^<#
        #.<..<<#
        #>v.><>#
        #<^v^^>#
        ######.#
            """;

    @Test
    public void testPart1() {
        final var actual = new Day24Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(18,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day24Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(54,actual);
    }


}
