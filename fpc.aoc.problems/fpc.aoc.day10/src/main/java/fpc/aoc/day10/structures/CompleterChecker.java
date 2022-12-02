package fpc.aoc.day10.structures;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CompleterChecker {
    INSTANCE,
    ;

    public static CompleterChecker create() {
        return INSTANCE;
    }

    private static final BigInteger FIVE = BigInteger.valueOf(5);

    private static final ImmutableMap<Character, Character> OPENING_CHAT = ImmutableMap.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'
    );
    private static final ImmutableMap<Character, BigInteger> SCORE_TABLE = ImmutableMap.of(
            ')', BigInteger.valueOf(1),
            ']', BigInteger.valueOf(2),
            '}', BigInteger.valueOf(3),
            '>', BigInteger.valueOf(4));

    public Optional<BigInteger> complete(@NonNull String line) {
        final Deque<Character> pile = new ArrayDeque<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            final var c = line.charAt(i);
            final var closingChar = OPENING_CHAT.get(c);

            if (closingChar == null) {
                final var lastOpening = pile.isEmpty() ? ' ' : pile.removeLast();
                if (lastOpening != c) {
                    return Optional.empty();
                }
            } else {
                pile.addLast(closingChar);
            }
        }

        BigInteger score = BigInteger.ZERO;
        while (!pile.isEmpty()) {
            score = score.multiply(FIVE).add(SCORE_TABLE.get(pile.removeLast()));
        }

        return Optional.of(score);
    }


}
