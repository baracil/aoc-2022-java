import fpc.aoc.api.AOCProblem;
import fpc.aoc.day8.Day8Part1Solver;
import fpc.aoc.day8.Day8Part2Solver;

module fpc.aoc.day8 {
    requires static lombok;

    requires fpc.aoc.input;

    requires com.google.common;

    exports fpc.aoc.day8;
    exports fpc.aoc.day8.struct;

//    provides AOCProblem with Day8Part1Solver, Day8Part2Solver;
}
