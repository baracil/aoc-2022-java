package fpc.aoc.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day9SolverTest {

    public static final String INPUT_TEST = """
            2199943210
            3987894921
            9856789892
            8767896789
            9899965678
            """;

    @Test
    public void test_part1() {
        final var actual = new Day9Part1Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals(15,actual);
    }

    @Test
    public void test_part2() {
        final var actual = new Day9Part2Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals(1134,actual);
    }
}
