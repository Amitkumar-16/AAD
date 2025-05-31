import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class DijkstraAlgorithm {
    public static void dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            for (Edge neighbour : graph.get(u)) {
                int v = neighbour.to;
                int weight = neighbour.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int n = 6;  // number of nodes
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Example edges (undirected graph)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(2, 5));
        graph.get(1).add(new Edge(3, 10));
        graph.get(2).add(new Edge(4, 3));
        graph.get(4).add(new Edge(3, 4));
        graph.get(3).add(new Edge(5, 11));

        dijkstra(graph, 0);
    }
}
