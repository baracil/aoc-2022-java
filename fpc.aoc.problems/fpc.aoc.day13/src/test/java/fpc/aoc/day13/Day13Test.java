package fpc.aoc.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day13Test {

    public static final String TEST_INPUT = """
        [1,1,3,1,1]
        [1,1,5,1,1]
        
        [[1],[2,3,4]]
        [[1],4]
        
        [9]
        [[8,7,6]]
        
        [[4,4],4,4]
        [[4,4],4,4,4]
        
        [7,7,7,7]
        [7,7,7]
        
        []
        [3]
        
        [[[]]]
        [[]]
        
        [1,[2,[3,[4,[5,6,7]]]],8,9]
        [1,[2,[3,[4,[5,6,0]]]],8,9]
            """;

    @Test
    public void testPart1() {
        final var actual = new Day13Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(13,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day13Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(140,actual);
    }

    @Test
    public void testPair2() {
        final var item1 = ItemParser.parse("[[1],[2,3,4]]");
        final var item2 = ItemParser.parse("[[1],4]");
        Assertions.assertTrue(item1.compareTo(item2) < 0);
    }

}
