package fpc.aoc.day10;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class VideoSystem {

  private int x = 1;
  private int cycle = 1;
  private final Crt crt = new Crt();

  @Getter
  private final @NonNull List<Integer> signalStrength = new ArrayList<>(220);

  public void execute(@NonNull CommandProvider commandProvider) {
    Command pending = null;
    int nbCycleBeforeExecution = 0;

    signalStrength.add(0);

    do {

      final var col = ((cycle-1)%40);

      if (Math.abs(x - col)<=1) {
        crt.drawPixel(cycle);
      }
      final var st = cycle * x;
      signalStrength.add(st);
      System.out.printf("cycle:%03d  x:%2d  st:%d", cycle, x, st);
      System.out.println();

      if (nbCycleBeforeExecution == 0) {
        pending = commandProvider.takeCommand().orElse(null);
        if (pending != null) {
          nbCycleBeforeExecution = pending.nbCycles();
        }
      }
      cycle++;
      nbCycleBeforeExecution--;

      if (nbCycleBeforeExecution == 0) {
        this.x = pending.applyToRegister(this.x);
      }


    } while (pending != null);
  }

  public String dumpDisplay() {
    return crt.dumpDisplay();
  }
}


