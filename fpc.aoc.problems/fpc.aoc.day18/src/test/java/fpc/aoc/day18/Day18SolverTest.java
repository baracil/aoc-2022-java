package fpc.aoc.day18;

import fpc.aoc.day18.struct.Number;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day18SolverTest {

  public static Stream<Arguments> explodingSamples() {
    return Stream.of(
            Arguments.of("[[[[[9,8],1],2],3],4]","[[[[0,9],2],3],4]"),
            Arguments.of("[7,[6,[5,[4,[3,2]]]]]","[7,[6,[5,[7,0]]]]"),
            Arguments.of("[[6,[5,[4,[3,2]]]],1]","[[6,[5,[7,0]]],3]"),
            Arguments.of("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]","[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]"),
            Arguments.of("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]","[[3,[2,[8,0]]],[9,[5,[7,0]]]]")
    );
  }

  public static Stream<Arguments> addingSamples() {
    return Stream.of(
            Arguments.of("[[[[4,3],4],4],[7,[[8,4],9]]]","[1,1]", "[[[[0,7],4],[[7,8],[6,0]]],[8,1]]"),
            Arguments.of("[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]","[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]", "[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]")
    );
  }

  @ParameterizedTest
  @MethodSource("explodingSamples")
  public void testExplode(@NonNull String toExplode, @NonNull String expected) {
    final var number = Number.parse(toExplode);
    number.explode();
    Assertions.assertEquals(expected, number.toString());
  }

  @ParameterizedTest
  @MethodSource("addingSamples")
  public void testAddition(@NonNull String lhs, @NonNull String rhs, @NonNull String expected) {
    final var n1 = Number.parse(lhs);
    final var n2 = Number.parse(rhs);
    final var actual = n1.add(n2);
    Assertions.assertEquals(expected,actual.toString());
  }

  public static final String TEST_INPUT = """
          [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
          [[[5,[2,8]],4],[5,[[9,9],0]]]
          [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
          [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
          [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
          [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
          [[[[5,4],[7,7]],8],[[8,3],8]]
          [[9,3],[[9,9],[6,[4,9]]]]
          [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
          [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]
          """;

  @Test
  public void testPart1() {
    final Long actual = new Day18Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(4140,actual);
  }

  @Test
  public void testPart2() {
    final Long actual = new Day18Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(3993,actual);
  }
}
