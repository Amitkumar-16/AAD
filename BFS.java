
    import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
    public class BFS {
        public static void bfs(int start, List<List<Integer>> graph) {
            boolean[] visited = new boolean[graph.size()];
            Queue<Integer> queue = new LinkedList<>();
    
            queue.offer(start);
            visited[start] = true;
    
            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");
    
                for (int neighbour : graph.get(node)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }
    
        public static void main(String[] args) {
            List<List<Integer>> graph = new ArrayList<>();
            int n = 5;
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    
            graph.get(0).add(1); 
            graph.get(0).add(2);
            graph.get(1).add(3);
            graph.get(2).add(4);
    
            bfs(0, graph); 
        }
    }
    