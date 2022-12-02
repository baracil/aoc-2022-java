package fpc.aoc.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11SolverTest {

    public static final String INPUT_TEST = """
            5483143223
            2745854711
            5264556173
            6141336146
            6357385478
            4167524645
            2176841721
            6882881134
            4846848554
            5283751526
            """;

    @Test
    public void testPart1() {
        final var actual = new Day11Part1Solver().createProblem(INPUT_TEST).solve();

        Assertions.assertEquals("1656", actual);
    }
    @Test
    public void testPart2() {
        final var actual = new Day11Part2Solver().createProblem(INPUT_TEST).solve();

        Assertions.assertEquals("195", actual);
    }
}
