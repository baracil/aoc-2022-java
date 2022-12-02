package fpc.aoc.day14.struct;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Rules {

    private final ImmutableMap<Couple,Character> rules;


    public @NonNull Optional<Character> getInsertion(@NonNull Couple couple) {
        return Optional.ofNullable(rules.get(couple));
    }

    public static final Collector<InsertionRule,?,Rules> COLLECTOR =
            Collectors.collectingAndThen(
                    ImmutableMap.toImmutableMap(InsertionRule::couple, InsertionRule::middle),
                    Rules::new
            );
}
