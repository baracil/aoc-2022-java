package fpc.aoc.day22;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day22Part1Solver extends Day22Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Input22 input) {
        var player = input.map().start();
        System.out.println(player);

        for (Order order : input.orders()) {
            player = order.apply(player,input.map());
            System.out.println(player);
        }

        return (long)player.getValue();
    }
}
