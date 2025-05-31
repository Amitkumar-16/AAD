import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class KruskalEdge {
    int src, dest, weight;
    KruskalEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class KruskalsMST {
    static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (xRoot == yRoot) return;
        if (rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
        else if (rank[xRoot] > rank[yRoot]) parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    public static void kruskals(List<KruskalEdge> edges, int n) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int mstWeight = 0;
        for (KruskalEdge e : edges) {
            if (find(parent, e.src) != find(parent, e.dest)) {
                mstWeight += e.weight;
                union(parent, rank, e.src, e.dest);
            }
        }

        System.out.println("Total weight of MST (Kruskal's): " + mstWeight);
    }

    public static void main(String[] args) {
        int n = 5;
        List<KruskalEdge> edges = new ArrayList<>();

        edges.add(new KruskalEdge(0, 1, 2));
        edges.add(new KruskalEdge(0, 3, 6));
        edges.add(new KruskalEdge(1, 2, 3));
        edges.add(new KruskalEdge(1, 3, 8));
        edges.add(new KruskalEdge(1, 4, 5));
        edges.add(new KruskalEdge(2, 4, 7));

        kruskals(edges, n);
    }
}

