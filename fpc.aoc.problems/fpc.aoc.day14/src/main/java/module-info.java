import fpc.aoc.api.AOCProblem;
import fpc.aoc.day14.Day14Part1Solver;
import fpc.aoc.day14.Day14Part2Solver;

module fpc.aoc.day14 {
    requires static lombok;

    requires fpc.aoc.input;
    requires com.google.common;
    exports fpc.aoc.day14;
    exports fpc.aoc.day14.struct;

//    provides AOCProblem with Day14Part1Solver, Day14Part2Solver;
}
