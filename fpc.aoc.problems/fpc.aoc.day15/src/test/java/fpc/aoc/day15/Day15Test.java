package fpc.aoc.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day15Test {

    public static final String TEST_INPUT = """
        Sensor at x=2, y=18: closest beacon is at x=-2, y=15
        Sensor at x=9, y=16: closest beacon is at x=10, y=16
        Sensor at x=13, y=2: closest beacon is at x=15, y=3
        Sensor at x=12, y=14: closest beacon is at x=10, y=16
        Sensor at x=10, y=20: closest beacon is at x=10, y=16
        Sensor at x=14, y=17: closest beacon is at x=10, y=16
        Sensor at x=8, y=7: closest beacon is at x=2, y=10
        Sensor at x=2, y=0: closest beacon is at x=2, y=10
        Sensor at x=0, y=11: closest beacon is at x=2, y=10
        Sensor at x=20, y=14: closest beacon is at x=25, y=17
        Sensor at x=17, y=20: closest beacon is at x=21, y=22
        Sensor at x=16, y=7: closest beacon is at x=15, y=3
        Sensor at x=14, y=3: closest beacon is at x=15, y=3
        Sensor at x=20, y=1: closest beacon is at x=15, y=3
        """;

    @Test
    public void testPart1() {
        final var actual = new Day15Part1Solver(10).createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(26,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day15Part2Solver(20).createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(56000011,actual);
    }


}
