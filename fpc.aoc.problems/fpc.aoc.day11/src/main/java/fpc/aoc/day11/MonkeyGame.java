package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.Top;
import lombok.Getter;

import java.util.Arrays;

public class MonkeyGame {

  private final ImmutableList<Monkey> monkeys;

  @Getter
  private final int[] nbInspection;

  public MonkeyGame(ImmutableList<Monkey> monkeys) {
    this.monkeys = monkeys;
    this.nbInspection = new int[monkeys.size()];
  }

  public void performOneTurn() {

    for (int i = 0; i < monkeys.size(); i++) {
      final var monkey = monkeys.get(i);
      final var thrownItems = monkey.inspect();

      nbInspection[i] += thrownItems.size();

      for (Throw thrownItem : thrownItems) {
        monkeys.get(thrownItem.monkeyIndex()).catchItem(thrownItem.item());
      }
    }
  }
  
  public long getMonkeyBusiness() {
    final var top = new Top(2);
    Arrays.stream(nbInspection).forEach(top::handle);
    return top.product();
  }
}
