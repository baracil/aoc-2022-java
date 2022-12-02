import fpc.aoc.api.AOCProblem;
import fpc.aoc.day18.Day18Part1Solver;
import fpc.aoc.day18.Day18Part2Solver;

module fpc.aoc.day18 {
    requires static lombok;

    requires fpc.aoc.input;

    requires com.google.common;

    exports fpc.aoc.day18;
    exports fpc.aoc.day18.struct;

//    provides AOCProblem with Day18Part1Solver, Day18Part2Solver;
}
