package fpc.oac.day3;

import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {

    public static final String INPUT = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
            """;

    @Test
    public void testExamplePart1() {
        final var actual = new Day3Part1Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(157,actual);
    }

    @Test
    public void testExamplePart2() {
        final var actual = new Day3Part2Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(70,actual);
    }


}
