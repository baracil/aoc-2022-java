package fpc.aoc.day10.structures;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SyntaxChecker {
    INSTANCE,
    ;

    public static SyntaxChecker create() {
        return INSTANCE;
    }

    private static final ImmutableMap<Character, Character> OPENING_CHAT = ImmutableMap.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'
    );
    private static final ImmutableMap<Character, Integer> SCORE_TABLE = ImmutableMap.of(
            ')', 3,
            ']', 57,
            '}', 1197,
            '>', 25137);

    public int check(@NonNull String line) {
        final Deque<Character> pile = new ArrayDeque<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            final var c = line.charAt(i);
            final var closingChar = OPENING_CHAT.get(c);

            if (closingChar == null) {
                final var lastOpening = pile.isEmpty() ? ' ' : pile.removeLast();
                if (lastOpening != c) {
                    return SCORE_TABLE.get(c);

                }
            } else {
                pile.addLast(closingChar);
            }
        }
        return 0;
    }


}
