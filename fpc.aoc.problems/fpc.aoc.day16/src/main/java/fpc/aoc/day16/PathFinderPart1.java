package fpc.aoc.day16;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

public class PathFinderPart1 {

  public static Step findBest(@NonNull Network network) {
    return new PathFinderPart1(network).findBest();
  }


  private final @NonNull Network network;
  private final ValveState allClosed;
  private final Map<Key, Best> cache = new HashMap<>();


  private PathFinderPart1(@NonNull Network network) {
    this.network = network;
    final var valveHelper = ValveHelper.create(network.getUsefulValves());
    this.allClosed = valveHelper.allClosedState();
  }

  public Step findBest() {
    return computeStep(new Key("AA", allClosed, 31), 0, ActionType.START);
  }

  private Step computeStep(@NonNull Key state, int newRate, ActionType actionType) {
    if (state.timeLeft == 0) {
      return null;
    }

    final Best best;
    final var cached = cache.get(state);
    if (cached != null) {
      best = cached;
    } else {
      best = computeBest(state);
    }

    final var step = Step.first(state.valve, newRate,actionType);
    if (best.step == null) {
      return step;
    } else {
      return best.step.useForRoot(step);
    }
  }


  private Best computeBest(@NonNull Key state) {
    final var connections = network.getConnections(state.valve());

    Best best = Best.EMPTY;
    if (!state.valveIsOpen()) {
      final var rate = network.getRate(state.valve);
      final var newState = state.withOpenedValve();
      best = best.handle(computeStep(newState, rate, ActionType.OPEN_VALVE));
    }

    for (String connection : connections) {
      final var newKey = state.moveTo(connection);
      final var potentialBest = computeStep(newKey, 0,ActionType.MOVE);

      best = best.handle(potentialBest);
    }

    cache.put(state, best);
    return best;
  }

  @RequiredArgsConstructor
  @ToString(of = "step")
  private static class Best {
    private final Step step;


    public static Best EMPTY = new Best(null);

    public Best handle(Step step) {
      if (step == null) {
        return this;
      }
      if (this.step == null || this.step.totalVent() <= step.totalVent()) {
        return new Best(step);
      }
      return this;
    }
  }

  @Value
  private static class Key {
    @NonNull String valve;
    @NonNull ValveState valveState;
    int timeLeft;

    public boolean valveIsOpen() {
      return valveState.isOpen(valve);
    }

    @Override
    public String toString() {
      return "Key{" + valve + " " + valveState.opened() + "  " + timeLeft + '}';
    }

    public Key withOpenedValve() {
      return new Key(valve, valveState.open(valve), timeLeft - 1);
    }

    public Key moveTo(String connection) {
      return new Key(connection, valveState, timeLeft - 1);
    }
  }

}
