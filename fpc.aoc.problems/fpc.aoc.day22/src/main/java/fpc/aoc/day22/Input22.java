package fpc.aoc.day22;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.ArrayOfChar;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Getter
public class Input22 {

    private final Map map;
    private final ImmutableList<Order> orders;


    private static final Pattern PATTERN = Pattern.compile("(?<length>[0-9]+)(?<op>[LRF])");

    public static Input22 parse(ImmutableList<String> lines, @NonNull NavigationFactory navigationFactory) {
        final var idx = IntStream.range(0,lines.size()).filter(i -> lines.get(i).isEmpty()).findAny().orElseThrow();
        final var map = ArrayOfChar.from(lines.subList(0,idx),' ');

        final var builder = ImmutableList.<Order>builder();
        final var l = lines.get(idx+1)+"F";
        final var matcher = PATTERN.matcher(l);
        while(matcher.find()) {
            builder.add(new Order.Move(Integer.parseInt(matcher.group("length"))));
            switch (matcher.group("op")) {
                case "R" -> builder.add(new Order.RotateR());
                case "L" -> builder.add(new Order.RotateL());
            }
        }

        return new Input22(new Map(map,navigationFactory.create(map)),builder.build());
    }
}
