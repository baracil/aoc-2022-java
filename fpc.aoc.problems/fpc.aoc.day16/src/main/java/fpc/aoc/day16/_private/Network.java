package fpc.aoc.day16._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Pair;
import fpc.aoc.day16.Valves;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Network {

  private final Map<String, Integer> rates; //rate of the valve by valve name
  private final Map<String, Set<String>> connections; //connection for each valve


  public @NonNull Valves buildValves() {
    final var names = rates.entrySet()
        .stream()
        .filter(e -> e.getKey().equals("AA") || e.getValue()>0)
        .map(Map.Entry::getKey)
        .sorted()
        .toArray(String[]::new);

    final var rates = new int[names.length];
    final var distances = new int[names.length][names.length];

    for (int i = 0; i < names.length; i++) {
      rates[i] = this.rates.get(names[i]);
      for (int j = i; j < names.length; j++) {
        final var d = distance(names[i], names[j]);
        distances[i][j] = d;
        distances[j][i] = d;
      }
    }

    return new Valves( names, rates, distances);
  }

  public int distance(String start, String end) {
    final Deque<Pair<String,Integer>> toVisit = new LinkedList<>();
    final Set<String> visited = new HashSet<>();

    toVisit.add(Pair.of(start,0));
    visited.add(start);
    do {
      final var p = toVisit.pollFirst();
      if (p == null) {
        throw new AOCException("NOT CONNECTED");
      }
      final var valve = p.first();
      if (valve.equals(end)) {
        return p.second();
      }

      connections.get(valve)
          .stream()
          .filter(v -> !visited.contains(v))
          .forEach(v -> {
              visited.add(v);
              toVisit.add(Pair.of(v,p.second()+1));
      });

    } while (true);
  }

//  public void simplify() {
//    final var names = new HashSet<>(rates.keySet());
//    for (String center : names) {
//      if (rates.get(center) != 0 || center.equals("AA")) {
//        continue;
//      }
//      rates.remove(center);
//      final var linked = new ArrayList<>(connections.remove(center));
//      for (int i = 0; i < linked.size(); i++) {
//        for (int j = i + 1; j < linked.size(); j++) {
//          final var n1 = linked.get(i);
//          final var n2 = linked.get(j);
//
//          connections.get(n1).remove(center);
//          connections.get(n2).remove(center);
//
//          connections.get(n1).add(n2);
//          connections.get(n2).add(n1);
//
//          final var l1 = edges.get(new Edge(center, n1));
//          final var l2 = edges.get(new Edge(center, n2));
//          final var n12 = new Edge(n1, n2);
//
//          edges.merge(n12, l1 + l2, Math::min);
//        }
//      }
//
//      for (String s : linked) {
//        edges.remove(new Edge(s, center));
//      }
//    }
//  }

//  @Value
//  public static class Edge {
//    @NonNull String valve1;
//    @NonNull String valve2;
//
//    public Edge(@NonNull String valve1, @NonNull String valve2) {
//      if (valve1.compareTo(valve2) > 0) {
//        this.valve1 = valve2;
//        this.valve2 = valve1;
//      } else {
//        this.valve1 = valve1;
//        this.valve2 = valve2;
//      }
//    }
//  }

  @Value
  public static class NetworkAggregator {

    public static final Collector<String, ?, Valves> COLLECTOR = Collector.of(
        NetworkAggregator::new,
        NetworkAggregator::addLine,
        NetworkAggregator::combine,
        NetworkAggregator::build
    );

    private static final Pattern PATTERN = Pattern.compile("^Valve (?<name>[A-Z]{2}).*rate=(?<rate>[0-9]+);.*valves? (?<connected>.+)$");

    Map<String, Integer> valves = new HashMap<>();
    Map<String, Set<String>> connections = new HashMap<>();


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
    }

    public NetworkAggregator combine(@NonNull Network.NetworkAggregator other) {
      throw new AOCException("Dunno");
    }

    public Valves build() {
      final var network = new Network(valves, connections);
      return network.buildValves();
    }


  }
}
