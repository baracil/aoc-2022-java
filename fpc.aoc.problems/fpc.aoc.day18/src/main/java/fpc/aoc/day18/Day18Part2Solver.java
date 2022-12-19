package fpc.aoc.day18;

import com.google.common.collect.ImmutableSet;
import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

//4126 to high
public class Day18Part2Solver extends Day18Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day18Part2Solver().createProblem();
  }


  @Override
  public @NonNull Integer solve(@NonNull ImmutableSet<Face> faces) {
    final var expander = new Expander(faces);
    final var touchedFaces = expander.expand();

    return touchedFaces.size();
  }


}
