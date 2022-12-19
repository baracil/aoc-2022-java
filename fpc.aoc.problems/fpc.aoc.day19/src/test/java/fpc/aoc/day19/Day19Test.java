package fpc.aoc.day19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day19Test {

    public static final String TEST_INPUT = """
        Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 3 ore and 14 clay. Each geode robot costs 2 ore and 7 obsidian.
        Blueprint 2: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 8 clay. Each geode robot costs 3 ore and 12 obsidian.
        """;

    @Test
    public void testPart1() {
        final var actual = new Day19Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(33,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day19Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(62*56,actual);
    }


}
