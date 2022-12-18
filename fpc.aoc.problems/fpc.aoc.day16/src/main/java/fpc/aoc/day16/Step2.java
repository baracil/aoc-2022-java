package fpc.aoc.day16;

import lombok.NonNull;

import java.io.PrintStream;

public record Step2(@NonNull Step step1, @NonNull Step step2) {

  public int totalVent() {
    return step1.totalVent()+step2.totalVent();
  }

  public Step2 useForRoot(Step2 step) {
    return new Step2(step1.useForRoot(step.step1),step2.useForRoot(step.step2));
  }

  public void dump(PrintStream ps) {
    step1.dump(ps);
    step2.dump(ps);
  }
}
