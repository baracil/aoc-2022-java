package fpc.aoc.day16.struct;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Reader {

    private final @NonNull String message;
    private final int end;
    private int index;

    public static @NonNull Reader fromHexaString(String hexaPacket) {
        final var binPacket = hexaPacket.chars().mapToObj(HEX_TO_BIN_DIGITS::get).collect(Collectors.joining());
        return new Reader(binPacket,binPacket.length(),0);
    }

    public int read(int nbBits) {
        final var pos = move(nbBits);
        return Integer.parseInt(message.substring(pos, this.index), 2);
    }

    public @NonNull Reader extract(int length) {
        final var pos = move(length);
        return new Reader(message,this.index,pos);
    }

    private int move(int nbBits) {
        if (index+nbBits > end) {
            throw new IndexOutOfBoundsException();
        }
        final var pos = index;
        this.index+=nbBits;
        return pos;
    }

    public int remaining() {
        return end - index;
    }


    private static final ImmutableMap<Integer,String> HEX_TO_BIN_DIGITS = ImmutableMap.<Integer,String>builder()
            .put('0'+0,"0000")
            .put('1'+0,"0001")
            .put('2'+0,"0010")
            .put('3'+0,"0011")
            .put('4'+0,"0100")
            .put('5'+0,"0101")
            .put('6'+0,"0110")
            .put('7'+0,"0111")
            .put('8'+0,"1000")
            .put('9'+0,"1001")
            .put('A'+0,"1010")
            .put('B'+0,"1011")
            .put('C'+0,"1100")
            .put('D'+0,"1101")
            .put('E'+0,"1110")
            .put('F'+0,"1111")
            .build();

}
