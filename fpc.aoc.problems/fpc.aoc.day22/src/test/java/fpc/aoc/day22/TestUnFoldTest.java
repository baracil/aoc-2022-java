package fpc.aoc.day22;

import fpc.aoc.common.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestUnFoldTest {

  private final UnFold unFold = new TestUnFold();

  public static Stream<Arguments> samplesRight() {
    return Stream.of(
        Arguments.of(Position.of(11,5),new Move(Position.of(14,8),Orientation.DOWN))
    );
  }

  public static Stream<Arguments> samplesDown() {
    return Stream.of(
        Arguments.of(Position.of(10,11),new Move(Position.of(1,7),Orientation.UP))
    );
  }

  @ParameterizedTest
  @MethodSource("samplesRight")
  public void testRight(Position start, Move expected) {
    final var actual = unFold.findNext(start,Orientation.RIGHT);
    Assertions.assertEquals(expected,actual);
  }

  @ParameterizedTest
  @MethodSource("samplesDown")
  public void testDown(Position start, Move expected) {
    final var actual = unFold.findNext(start,Orientation.DOWN);
    Assertions.assertEquals(expected,actual);
  }
}
