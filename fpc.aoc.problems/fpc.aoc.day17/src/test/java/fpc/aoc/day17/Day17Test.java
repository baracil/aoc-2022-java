package fpc.aoc.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day17Test {

    public static final String TEST_INPUT = """
            >>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>
            """;

    @Test
    public void testPart1() {
        final var actual = new Day17Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(3068,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day17Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(1514285714288L,actual);
    }


}
