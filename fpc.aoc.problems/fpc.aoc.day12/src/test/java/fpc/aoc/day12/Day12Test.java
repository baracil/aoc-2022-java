package fpc.aoc.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day12Test {

    public static final String TEST_INPUT = """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
            """;

    @Test
    public void testPart1() {
        final var actual = new Day12Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(31,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day12Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(29,actual);
    }


}
