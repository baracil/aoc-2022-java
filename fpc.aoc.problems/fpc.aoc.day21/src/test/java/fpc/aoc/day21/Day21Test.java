package fpc.aoc.day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day21Test {

    public static final String TEST_INPUT = """
            root: pppw + sjmn
            dbpl: 5
            cczh: sllz + lgvd
            zczc: 2
            ptdq: humn - dvpt
            dvpt: 3
            lfqf: 4
            humn: 5
            ljgn: 2
            sjmn: drzm * dbpl
            sllz: 4
            pppw: cczh / lfqf
            lgvd: ljgn * ptdq
            drzm: hmdt - zczc
            hmdt: 32
            """;

    @Test
    public void testPart1() {
        final var actual = new Day21Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(152,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day21Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(301,actual);
    }


}
