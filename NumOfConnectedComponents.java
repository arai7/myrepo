import java.util.*;

public class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the graph using adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);  // since the graph is undirected
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Step 2: BFS on every unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int nodeCount = 0;
                int edgeCount = 0;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    nodeCount++;

                    for (int neighbor : graph.get(node)) {
                        edgeCount++;
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }

                // Step 3: Each undirected edge is counted twice, so divide by 2
                edgeCount /= 2;

                // Step 4: Check if the component is complete
                if (edgeCount == nodeCount * (nodeCount - 1) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }
}
