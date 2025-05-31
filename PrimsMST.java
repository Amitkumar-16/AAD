import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int dest, weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class PrimsMST {
    public static void prims(List<List<Edge>> graph, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(0, 0));
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (visited[u]) continue;
            visited[u] = true;
            mstWeight += current.weight;

            for (Edge e : graph.get(u)) {
                if (!visited[e.dest]) {
                    pq.offer(e);
                }
            }
        }

        System.out.println("Total weight of MST (Prim's): " + mstWeight);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        prims(graph, n);
    }
}

