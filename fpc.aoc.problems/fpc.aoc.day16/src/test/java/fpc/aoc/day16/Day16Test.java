package fpc.aoc.day16;

import fpc.aoc.common.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day16Test {

    public static final String TEST_INPUT = """
        Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
        Valve BB has flow rate=13; tunnels lead to valves CC, AA
        Valve CC has flow rate=2; tunnels lead to valves DD, BB
        Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
        Valve EE has flow rate=3; tunnels lead to valves FF, DD
        Valve FF has flow rate=0; tunnels lead to valves EE, GG
        Valve GG has flow rate=0; tunnels lead to valves FF, HH
        Valve HH has flow rate=22; tunnel leads to valve GG
        Valve II has flow rate=0; tunnels lead to valves AA, JJ
        Valve JJ has flow rate=21; tunnel leads to valve II
            """;

    @Test
    public void testPart1() {
        final var actual = new Day16Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(1651,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day16Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }


}
