import fpc.aoc.api.AOCProblem;
import fpc.aoc.day6.Day6Part1Solver;
import fpc.aoc.day6.Day6Part2Solver;

module fpc.aoc.day6 {
    requires static lombok;

    requires fpc.aoc.input;
    requires com.google.common;

    exports fpc.aoc.day6;
    exports fpc.aoc.day6.struct;

//    provides AOCProblem with Day6Part1Solver, Day6Part2Solver;
}
