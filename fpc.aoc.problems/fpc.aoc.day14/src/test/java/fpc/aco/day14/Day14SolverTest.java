package fpc.aco.day14;

import fpc.aoc.day14.Day14Part1Solver;
import fpc.aoc.day14.Day14Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14SolverTest {

    public static final String INPUT = """
            NNCB
                        
            CH -> B
            HH -> N
            CB -> H
            NH -> C
            HB -> C
            HC -> B
            HN -> C
            NN -> C
            BH -> H
            NC -> B
            NB -> B
            BN -> B
            BB -> N
            BC -> B
            CC -> N
            CN -> C""";

    @Test
    public void testPart1() {
        final var actual = new Day14Part1Solver().createProblem(INPUT).solve();
        Assertions.assertEquals("1588",actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day14Part2Solver().createProblem(INPUT).solve();
        Assertions.assertEquals("2188189693529",actual);
    }
}
