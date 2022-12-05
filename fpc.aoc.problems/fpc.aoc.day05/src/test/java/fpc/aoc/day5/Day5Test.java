package fpc.aoc.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day5Test {

    public static final String TEST_INPUT = """
            [D]   \s
        [N] [C]   \s
        [Z] [M] [P]
         1   2   3\s
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
        """;

    @Test
    public void testPart1() {
        final var actual = new Day5Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("CMZ",actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day5Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("MCD",actual);
    }


}
