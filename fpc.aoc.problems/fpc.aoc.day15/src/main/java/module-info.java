import fpc.aoc.api.AOCProblem;
import fpc.aoc.day15.Day15Part1Solver;
import fpc.aoc.day15.Day15Part2Solver;

module fpc.aoc.day15 {
    requires static lombok;

    requires fpc.aoc.input;
    requires com.google.common;

    exports fpc.aoc.day15;
    exports fpc.aoc.day15.struct;

//    provides AOCProblem with Day15Part1Solver, Day15Part2Solver;
}
