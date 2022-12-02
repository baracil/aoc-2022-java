package fpc.aoc.day12.struct;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Graph {

    @Getter
    private final Node start;

    private final ImmutableMap<Node, ImmutableList<Node>> connections;





    public static Collector<Connection,?,Graph> COLLECTOR = Collector.of(
            GraphCollector::new,
            GraphCollector::pushConnection,
            GraphCollector::combine,
            GraphCollector::build
    );

    public @NonNull ImmutableList<Node> getConnections(@NonNull Node position) {
        return connections.getOrDefault(position,ImmutableList.of());
    }


    private static class GraphCollector {

        private Node start = null;

        private final Map<Node,ImmutableList.Builder<Node>> connections = new HashMap<>();

        private @NonNull Graph build() {
            return new Graph(start,connections.entrySet().stream().collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, e -> e.getValue().build())));
        }

        private void pushConnection(@NonNull Connection connection) {
            final var node1 = connection.node1();
            final var node2 = connection.node2();

            if (node1.start()) {
                this.start = node1;
            }
            if (node2.start()) {
                this.start = node2;
            }

            this.connections.computeIfAbsent(node1, n -> new ImmutableList.Builder<>()).add(node2);
            this.connections.computeIfAbsent(node2, n -> new ImmutableList.Builder<>()).add(node1);
        }

        public @NonNull GraphCollector combine(@NonNull GraphCollector a2) {
            if (a2.start != null) {
                this.start = a2.start;
            }

            a2.connections.forEach((node,connection) -> this.connections.computeIfAbsent(node, n -> new ImmutableList.Builder<>()).addAll(connection.build()));
            return this;
        }
    }
}
