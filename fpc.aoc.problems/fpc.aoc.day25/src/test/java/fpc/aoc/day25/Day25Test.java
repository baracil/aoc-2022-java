package fpc.aoc.day25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day25Test {

    public static final String TEST_INPUT = """
        1=-0-2
        12111
        2=0=
        21
        2=01
        111
        20012
        112
        1=-1=
        1-12
        12
        1=
        122
            """;

    @Test
    public void testPart1() {
        final var actual = new Day25Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("2=-1=0",actual);
    }


}
