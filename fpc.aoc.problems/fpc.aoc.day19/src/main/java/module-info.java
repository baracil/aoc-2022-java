import fpc.aoc.api.AOCProblem;
import fpc.aoc.day19.Day19Part1Solver;
import fpc.aoc.day19.Day19Part2Solver;

module fpc.aoc.day19 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;
    requires ojalgo;

    exports fpc.aoc.day19;

    provides AOCProblem with Day19Part1Solver, Day19Part2Solver;
}
