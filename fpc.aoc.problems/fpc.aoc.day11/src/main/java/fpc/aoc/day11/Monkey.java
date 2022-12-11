package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Monkey {

  private final Deque<Item> items;
  private final UnaryOperator<Item> operation;
  private final Function<Item,Throw> throwFunction;

  public Monkey(int[] items, UnaryOperator<Item> operation, Function<Item, Throw> throwFunction) {
    this.items = new LinkedList<>();
    Arrays.stream(items).mapToObj(Item::new).forEach(this.items::addLast);
    this.operation = operation;
    this.throwFunction = throwFunction;
  }

  public @NonNull ImmutableList<Throw> inspect() {
    final var throwBuild = ImmutableList.<Throw>builder();
    while (true) {
      final var item = items.pollFirst();
      if (item == null) {
        return throwBuild.build();
      }
      final var inspectedItem = operation.apply(item);
      throwBuild.add(throwFunction.apply(inspectedItem));
    }
  }

  public void catchItem(@NonNull Item item) {
    this.items.addLast(item);
  }

  @Override
  public String toString() {
    return "Monkey{" + items + '}';
  }
}
