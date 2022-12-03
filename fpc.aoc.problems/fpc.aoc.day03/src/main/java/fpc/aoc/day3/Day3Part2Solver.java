package fpc.aoc.day3;

import com.google.common.collect.ImmutableList;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public class Day3Part2Solver extends SmartSolver<ImmutableList<Group>, Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Group> input) {
        return input.stream().mapToInt(g -> g.getCommonItem()+1).sum();
    }

    @Override
    protected @NonNull Converter<ImmutableList<Group>> getConverter() {
        return Converter.IDENTITY
            .andThen(s -> s.map(Compartment::parse))
            .andThen(s -> s.collect(ImmutableList.toImmutableList()))
            .andThen(this::toGroups);
    }


    private ImmutableList<Group> toGroups(ImmutableList<Compartment> lines) {
        final var builder = ImmutableList.<Group>builder();
        for (int i = 0; i < lines.size(); i+=3) {
            builder.add(new Group(lines.subList(i,i+3)));
        }
        return builder.build();
    }

}
