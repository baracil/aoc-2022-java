package fpc.aoc.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay1Solver {

  public static final String TEST_INPUT = """
         1000
         2000
         3000
         
         4000
         
         5000
         6000
         
         7000
         8000
         9000
         
         10000
          """;

  @Test
  public void testExampleDay1Part1() {
    final long actual = new Day1Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(24000, actual);
  }
  @Test
  public void testExampleDay1Part2() {
    final long actual = new Day1Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(45000, actual);
  }

}
