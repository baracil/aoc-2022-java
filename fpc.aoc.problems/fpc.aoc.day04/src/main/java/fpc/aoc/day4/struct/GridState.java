package fpc.aoc.day4.struct;

public sealed interface GridState {

    record Winning(int score) implements GridState {}

    record NotWinning() implements GridState {}
}
