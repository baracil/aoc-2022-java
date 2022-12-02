package fpc.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay7 {

    public static final String INPUT_TEST = """
            16,1,2,0,4,2,7,1,2,14
            """;

    @Test
    public void testPart1() {
        final var actual = new Day7Part1Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals(37,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day7Part2Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals(168,actual);
    }
}
