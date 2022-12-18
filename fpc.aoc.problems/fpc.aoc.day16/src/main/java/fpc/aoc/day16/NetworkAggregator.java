package fpc.aoc.day16;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Value
public class NetworkAggregator {

  public static final Collector<String, ?, Network> COLLECTOR = Collector.of(
      NetworkAggregator::new,
      NetworkAggregator::addLine,
      NetworkAggregator::combine,
      NetworkAggregator::build
  );

  private static final Pattern PATTERN = Pattern.compile("^Valve (?<name>[A-Z]{2}).*rate=(?<rate>[0-9]+);.*valves? (?<connected>.+)$");

  Map<String, Integer> valves = new HashMap<>();
  Map<String, Set<String>> connections = new HashMap<>();
  Map<Edge, Integer> edges = new HashMap<>();


  public void addLine(@NonNull String line) {
    final var matcher = PATTERN.matcher(line);
    if (!matcher.matches()) {
      throw new AOCException("Cannot parse line '" + line + "'");
    }
    final var name = matcher.group("name");
    final var rate = Integer.parseInt(matcher.group("rate"));
    final var connected = Arrays.stream(matcher.group("connected").split(","))
        .map(String::trim).collect(Collectors.toSet());

    valves.put(name, rate);
    connections.put(name, connected);

    connected.forEach(e -> edges.put(new Edge(e,name),1));

  }

  public NetworkAggregator combine(@NonNull NetworkAggregator other) {
    throw new AOCException("Dunno");
  }

  public Network build() {
    return new Network(valves, connections,edges);
  }


}
