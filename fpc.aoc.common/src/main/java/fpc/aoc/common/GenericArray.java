package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;

public interface GenericArray<T> extends Array {

    @NonNull T get(@NonNull Position position);

    @NonNull T get(int x, int y);


    @Override
    default void printSingleElement(@NonNull PrintStream printStream, int x, int y) {
        printStream.print(get(x,y));
    }
}
