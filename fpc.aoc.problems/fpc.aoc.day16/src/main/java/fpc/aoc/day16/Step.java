package fpc.aoc.day16;

import lombok.NonNull;
import lombok.Value;

import java.io.PrintStream;
import java.util.ArrayList;

@Value
public class Step {
  String valve;
  int totalRate;
  int totalVent;
  Step previous;
  ActionType actionType;

  public Step(String valve, int totalRate, int totalVent, Step previous, ActionType actionType) {
    this.valve = valve;
    this.totalRate = totalRate;
    this.totalVent = totalVent;
    this.previous = previous;
    this.actionType = actionType;
  }

  public int totalVent() {
    return totalVent;
  }


  public static @NonNull Step first(String valve, int rate, @NonNull ActionType actionType) {
    return new Step(valve, rate, 0, null, actionType);
  }

  public Step useForRoot(Step newRoot) {
    final var list = new ArrayList<Step>();
    var current = this;
    do {
      list.add(current);
      current = current.previous;
    } while (current != null);

    current = newRoot;
    for (int i = list.size() - 1, j = 1; i >= 0; i--, j++) {
      final var s = list.get(i);
      current = new Step(
          s.valve,
          s.totalRate + newRoot.totalRate,
          s.totalVent + newRoot.totalVent + newRoot.totalRate * j,
          current, s.actionType);
    }

    return current;
  }

  public void dump(PrintStream ps) {
    ps.println(this);
  }

  @Override
  public String toString() {
    final var total = valve + " ( " + totalVent + "/" + totalRate + " " + actionType + " )";
    if (previous == null) {
      return total;
    }
    return previous + " -> " + total;
  }
}
