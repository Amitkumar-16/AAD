import java.util.ArrayList;
import java.util.List;

public class DFS {
        public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 5;
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1); graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        boolean[] visited = new boolean[n];
        dfs(0, visited, graph);  // Output: 0 1 3 2 4
    }
}

    
