package fpc.aoc.day11;

import com.google.common.collect.ImmutableList;
import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParsedMonkeyAgg {

  public static Collector<String,?,MonkeyGame> collect(@NonNull Function<ImmutableList<ParsedMonkey>,LongUnaryOperator> postOperationFactory) {
    return Collector.of(() -> new ParsedMonkeyAgg(postOperationFactory),ParsedMonkeyAgg::addLine,ParsedMonkeyAgg::combine,ParsedMonkeyAgg::build);

  }

  private final Function<ImmutableList<ParsedMonkey>, LongUnaryOperator> postOperationFactory;

  private final ImmutableList.Builder<ParsedMonkey> builder = ImmutableList.builder();
  private ParsedMonkey.Builder monkeyBuilder = null;

  public void addLine(@NonNull String line) {
    line = line.trim();
    if (line.isEmpty() || line.startsWith("Monkey")) {
      finalizeMonkeyBuilder();
    }
    if (line.startsWith("Monkey")) {
      monkeyBuilder = ParsedMonkey.builder();
      monkeyBuilder.index(getMonkeyIndex(line));
    } else if (line.startsWith("Starting")) {
      monkeyBuilder.items(extractItems(line));
    } else if (line.startsWith("Operation")) {
      monkeyBuilder.operation(parseOperation(line));
    } else if (line.startsWith("Test")) {
      monkeyBuilder.divisor(parseIntAtEndOfLine(line));
    } else if (line.startsWith("If true")) {
      monkeyBuilder.ifTrue(parseIntAtEndOfLine(line));
    } else if (line.startsWith("If false")) {
      monkeyBuilder.ifFalse(parseIntAtEndOfLine(line));
    }
  }

  public ParsedMonkeyAgg combine(@NonNull ParsedMonkeyAgg other) {
    throw new IllegalStateException("Not a parallel collector");
  }

  public MonkeyGame build() {
    finalizeMonkeyBuilder();

    final var parsed = builder.build();
    final var postOperation = postOperationFactory.apply(parsed);

    return parsed.stream().map(m -> m.createMonkey(postOperation))
        .collect(Collectors.collectingAndThen(ImmutableList.toImmutableList(),MonkeyGame::new));
  }

  private void finalizeMonkeyBuilder() {
    if (monkeyBuilder != null) {
      builder.add(monkeyBuilder.build());
    }
    monkeyBuilder = null;
  }


  private int[] extractItems(@NonNull String line) {
    final var idx = line.indexOf(":");
    return Arrays.stream(line.substring(idx + 1).split("[, ]"))
        .filter(Predicate.not(String::isEmpty))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  private int getMonkeyIndex(@NonNull String line) {
    return Integer.parseInt(line.trim().substring("Monkey ".length(),line.length()-1));
  }

  private int parseIntAtEndOfLine(@NonNull String line) {
    final var idx = line.lastIndexOf(" ");
    return Integer.parseInt(line.substring(idx+1));
  }

  private static final Pattern OPERATION_PATTERN = Pattern.compile(".* new = *(?<left>(old|[0-9]+)) *(?<op>[+*]) *(?<right>(old|[0-9]+))");

  private LongUnaryOperator parseOperation(@NonNull String line) {
    final var match = OPERATION_PATTERN.matcher(line);
    if (!match.matches()) {
      throw new AOCException("Could not parse operation from '"+line+"'");
    }
    final var left = match.group("left");
    final var right = match.group("right");
    final var op = match.group("op");

    if (left.equals("old") && right.equals("old")) {
      return op.equals("*")?o -> o*o:o -> o+o;
    }

    final int value;
    if (left.equals("old")) {
      value = Integer.parseInt(right);
    } else {
      value = Integer.parseInt(left);
    }

    return op.equals("*")?o -> o*value:o -> o+value;
  }

}
