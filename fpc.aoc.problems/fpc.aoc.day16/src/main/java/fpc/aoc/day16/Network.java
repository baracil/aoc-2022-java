package fpc.aoc.day16;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Network {

  private final Map<String, Integer> valves;
  private final Map<String, Set<String>> connections;
  private final Map<Edge, Integer> edges;


  public void dump() {
    final var ps = System.out;
    ps.println("@startdot");
    ps.println("graph valves {");
    valves.forEach((n, r) -> ps.printf("%s [label=\"%s\\n%d\"]%n", n, n, r));
    edges.forEach((k,v) -> System.out.printf("%s -- %s [label=\"%d\"]%n",k.valve1(),k.valve2(),v));
    ps.println("}");
    ps.println("@enddot");
  }

  public void simplify() {
    final var names = new HashSet<>(valves.keySet());
    for (String center : names) {
      if (valves.get(center) != 0 || center.equals("AA")) {
        continue;
      }
      valves.remove(center);
      final var linked = new ArrayList<>(connections.remove(center));
      for (int i = 0; i < linked.size(); i++) {
        for (int j = i+1; j < linked.size(); j++) {
          final var n1 = linked.get(i);
          final var n2 = linked.get(j);

          connections.get(n1).remove(center);
          connections.get(n2).remove(center);

          connections.get(n1).add(n2);
          connections.get(n2).add(n1);

          final var l1 = edges.get(new Edge(center,n1));
          final var l2 = edges.get(new Edge(center,n2));
          final var n12 = new Edge(n1,n2);

          edges.merge(n12,l1+l2, Math::min);
        }
      }

      for (String s : linked) {
        edges.remove(new Edge(s,center));
      }
    }
  }

}
