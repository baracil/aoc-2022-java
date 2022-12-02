import fpc.aoc.api.AOCProblem;
import fpc.aoc.day13.Day13Part1Solver;
import fpc.aoc.day13.Day13Part2Solver;

module fpc.aoc.day13 {
    requires static lombok;

    requires fpc.aoc.input;
    requires com.google.common;

    exports fpc.aoc.day13;
    exports fpc.aoc.day13.struct;

//    provides AOCProblem with Day13Part1Solver, Day13Part2Solver;
}
