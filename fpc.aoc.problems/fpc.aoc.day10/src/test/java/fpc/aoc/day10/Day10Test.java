package fpc.aoc.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day10Test {

    public static final String INPUT_TEST = """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]
            """;

    @Test
    public void testPart1() {
        final var actual = new Day10Part1Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals(26397, actual);
    }

    @Test
    public void testPart1OneLine() {
        final var actual = new Day10Part1Solver().createProblem("{([(<{}[<>[]}>{[]{[(<()>").solve();
        Assertions.assertEquals(1197, actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day10Part2Solver().createProblem(INPUT_TEST).solve();
        Assertions.assertEquals("288957", actual);
    }


    @Test
    public void testPart2Line2() {
        final var actual = new Day10Part2Solver().createProblem("[({(<(())[]>[[{[]{<()<>>").solve();
        Assertions.assertEquals("288957", actual);
    }
    @Test
    public void testPart2Line3() {
        final var actual = new Day10Part2Solver().createProblem("[(()[<>])]({[<{<<[]>>(").solve();
        Assertions.assertEquals("5566", actual);
    }
    @Test
    public void testPart2Line4() {
        final var actual = new Day10Part2Solver().createProblem("(((({<>}<{<{<>}{[]{[]{}").solve();
        Assertions.assertEquals("1480781", actual);
    }
    @Test
    public void testPart2Line1() {
        final var actual = new Day10Part2Solver().createProblem("{<[[]]>}<{[{[{[]{()[[[]").solve();
        Assertions.assertEquals("995444", actual);
    }

}
