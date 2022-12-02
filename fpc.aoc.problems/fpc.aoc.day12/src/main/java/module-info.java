import fpc.aoc.api.AOCProblem;
import fpc.aoc.day12.Day12Part1Solver;
import fpc.aoc.day12.Day12Part2Solver;

module fpc.aoc.day12 {
    requires static lombok;

    requires fpc.aoc.input;

    requires com.google.common;

    exports fpc.aoc.day12;
    exports fpc.aoc.day12.struct;

//    provides AOCProblem with Day12Part1Solver, Day12Part2Solver;
}
