import fpc.aoc.api.AOCProblem;
import fpc.aoc.day16.Day16Part1Solver;
import fpc.aoc.day16.Day16Part2Solver;

module fpc.aoc.day16 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day16;
  exports fpc.aoc.day16._private;

  provides AOCProblem with Day16Part1Solver, Day16Part2Solver;
}
