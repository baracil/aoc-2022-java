package fpc.aoc.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day22Test {

    public static final String TEST_INPUT = """
                    ...#
                    .#..
                    #...
                    ....
            ...#.......#
            ........#...
            ..#....#....
            ..........#.
                    ...#....
                    .....#..
                    .#......
                    ......#.
                       
            10R5L5R10L4R5L5
            """;

    @Test
    public void testPart1() {
        final var actual = new Day22Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(6032,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day22Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(5031,actual);
    }


}
