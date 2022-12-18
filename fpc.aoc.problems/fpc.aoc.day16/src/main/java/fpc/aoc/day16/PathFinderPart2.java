package fpc.aoc.day16;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class PathFinderPart2 {

  public static Step2 findBest(@NonNull Network network) {
    return new PathFinderPart2(network).findBest();
  }


  private final @NonNull Network network;
  private final ValveState allClosed;
  private final Map<Key, Best> cache = new HashMap<>();


  private PathFinderPart2(@NonNull Network network) {
    this.network = network;
    final var valveHelper = ValveHelper.create(network.getUsefulValves());
    this.allClosed = valveHelper.allClosedState();
  }

  public Step2 findBest() {
    return computeStep(new Key("AA", "AA", allClosed, 27), ActionType.START, 0, ActionType.START, 0);
  }

  private Step2 computeStep(@NonNull Key state, ActionType actionType1, int newRate1, ActionType actionType2, int newRate2) {
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

    final var step = new Step2(Step.first(state.valve1, newRate1, actionType1), Step.first(state.valve2, newRate2, actionType2));
    if (best.step == null) {
      return step;
    } else {
      return best.step.useForRoot(step);
    }
  }


  private Best computeBest(@NonNull Key state) {

    if (state.valveState.areAllOpened()) {
      return new Best(computeStep(state.stay(), ActionType.STAY,0,ActionType.STAY,0));
    }

    final var valve1 = state.valve1;
    final var valve2 = state.valve2;
    final var connections1 = network.getConnections(state.valve1());
    final var connections2 = network.getConnections(state.valve2());

    final var valve1Openable = !state.valve1IsOpen();
    final var valve2Openable = !state.valve2IsOpen();


    Best best = Best.EMPTY;

    if (valve1Openable && valve2Openable && !valve1.equals(valve2)) {
      final var rate1 = network.getRate(state.valve1);
      final var rate2 = network.getRate(state.valve2);
      final var newState = state.withBothOpened();
      best = best.handle(computeStep(newState, ActionType.OPEN_VALVE, rate1, ActionType.OPEN_VALVE, rate2));
    }

    if (valve1Openable) {
      final var rate1 = network.getRate(state.valve1);
      for (String c2 : connections2) {
        final var newState = state.withValve1Opened(c2);
        best = best.handle(computeStep(newState, ActionType.OPEN_VALVE, rate1, ActionType.MOVE, 0));
      }
    }
    if (valve2Openable) {
      final var rate2 = network.getRate(state.valve2);
      for (String c1 : connections1) {
        final var newState = state.withValve2Opened(c1);
        best = best.handle(computeStep(newState, ActionType.MOVE, 0, ActionType.OPEN_VALVE, rate2));
      }
    }

    for (String c2 : connections2) {
      for (String c1 : connections1) {
        final var newState = state.withBothMoving(c1, c2);
        best = best.handle(computeStep(newState, ActionType.MOVE, 0, ActionType.MOVE, 0));
      }
    }

    cache.put(state, best);
    return best;
  }

  @RequiredArgsConstructor
  @ToString(of = "step")
  private static class Best {
    private final Step2 step;


    public static Best EMPTY = new Best(null);

    public Best handle(Step2 step) {
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
    @NonNull String valve1;
    @NonNull String valve2;
    @NonNull ValveState valveState;
    int timeLeft;


    public boolean valve1IsOpen() {
      return valveState.isOpen(valve1);
    }

    public boolean valve2IsOpen() {
      return valveState.isOpen(valve2);
    }


    public Key withValve1Opened(@NonNull String newValve2) {
      return new Key(valve1, newValve2, valveState.open(valve1), timeLeft - 1);
    }

    public Key withValve2Opened(@NonNull String newValve1) {
      return new Key(newValve1, valve2, valveState.open(valve2), timeLeft - 1);
    }

    public Key withBothOpened() {
      return new Key(valve1, valve2, valveState.open(valve1, valve2), timeLeft - 1);
    }

    public Key withBothMoving(@NonNull String newValue1, @NonNull String newValue2) {
      return new Key(newValue1, newValue2, valveState, timeLeft - 1);
    }

    public Key stay() {
      return new Key(valve1,valve2,valveState,timeLeft-1);
    }
  }


}
