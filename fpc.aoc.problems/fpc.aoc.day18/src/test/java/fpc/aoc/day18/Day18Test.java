package fpc.aoc.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day18Test {

    public static final String TEST_INPUT = """
        2,2,2
        1,2,2
        3,2,2
        2,1,2
        2,3,2
        2,2,1
        2,2,3
        2,2,4
        2,2,6
        1,2,5
        3,2,5
        2,1,5
        2,3,5
            """;

    public static final String SMALL_INPUT = """
        -1,0,0,
        1,0,0,
        0,-1,0,
        0,1,0,
        0,0,1,
        0,0,-1
            """;

    @Test
    public void testPart1() {
        final var actual = new Day18Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(64,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day18Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(58,actual);
    }

    @Test
    public void testPart3() {
        final var actual = new Day18Part2Solver().createProblem(SMALL_INPUT).solve();
        Assertions.assertEquals(30,actual);
    }


}
