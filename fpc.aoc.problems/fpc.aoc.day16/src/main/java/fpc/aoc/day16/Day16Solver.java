package fpc.aoc.day16;

import fpc.aoc.day16.struct.Packet;
import fpc.aoc.day16.struct.PacketReader;
import lombok.NonNull;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day16Solver extends SmartSolver<Packet,Long> {

    @Override
    protected @NonNull Converter<Packet> getConverter() {
        return Converter.FIRST_LINE.andThen(PacketReader::read);
    }
}
