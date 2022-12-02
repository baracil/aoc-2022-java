package fpc.aoc.day19.struct;

import lombok.NonNull;

public record Match(int rotationIdx, @NonNull Vector offset, int nbMatch) {
}
