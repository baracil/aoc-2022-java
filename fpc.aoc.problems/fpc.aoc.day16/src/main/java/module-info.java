import fpc.aoc.api.AOCProblem;
import fpc.aoc.day16.Day16Part1Solver;
import fpc.aoc.day16.Day16Part2Solver;

module fpc.aoc.day16 {
    requires static lombok;

    requires fpc.aoc.input;
    requires com.google.common;

    exports fpc.aoc.day16;
    exports fpc.aoc.day16.struct;

//    provides AOCProblem with Day16Part1Solver, Day16Part2Solver;
}
