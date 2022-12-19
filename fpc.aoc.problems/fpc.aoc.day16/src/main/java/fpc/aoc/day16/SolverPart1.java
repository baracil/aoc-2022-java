package fpc.aoc.day16;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SolverPart1 {

  public static long solve(@NonNull Valves valves) {
    return new SolverPart1(valves).solve();
  }


  private final int maxTime = 30;
  private final Valves valves;
  private final int nbValves;
  private final int[] masks;

  private final Map<State, Integer> cache = new HashMap<>();

  public SolverPart1(Valves valves) {
    this.valves = valves;
    this.nbValves = valves.getNbValves();
    this.masks = new int[nbValves];
    for (int i = 0; i < nbValves; i++) {
      this.masks[i] = 1 << i;
    }
  }

  private long solve() {
    final var start = new State(0, masks[0], maxTime);

    return IntStream.range(0, nbValves)
        .filter(start::isClosed)
        .mapToLong(i -> findBestFrom(start, 0, 0, i))
        .max()
        .orElse(0);
  }

  private int findBestFrom(@NonNull State state, int rate, int total, int toOpen) {
    if (toOpen == 0) {
      return rate * state.timeLeft() + total;
    }

    final var timeToOpen = 1 + valves.distances(state.position, toOpen);
    if (timeToOpen > state.timeLeft()) {
      return -1;
    }

    final var newState = new State(toOpen, state.valveState | masks[toOpen], state.timeLeft() - timeToOpen);

    final var cached = cache.get(newState);
    if (cached != null) {
      return cached;
    }

    final var newRate = rate + valves.rate(toOpen);
    final var newTotal = total + rate * timeToOpen;

    final var max = IntStream.range(0, nbValves)
        .filter(newState::isClosed)
        .map(i -> findBestFrom(newState, newRate, newTotal, i))
        .max().orElse(-1);

    final var result = Math.max(max, rate * state.timeLeft() + total);

    cache.put(newState, result);
    return result;
  }


  @Value
  private class State {
    int position;
    int valveState;
    int timeLeft;

    public boolean isClosed(int valve) {
      return ((this.valveState) & masks[valve]) == 0;
    }


  }
}
