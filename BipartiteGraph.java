import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0 = unvisited, 1 = red, -1 = blue
        Arrays.fill(colors, 0);

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue; // Skip already colored nodes

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1; // Start with color 1

            while (!queue.isEmpty()) {
                int node = queue.poll();
                
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) { // If unvisited, color with opposite color
                        colors[neighbor] = -colors[node];
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[node]) { // Conflict found
                        return false;
                    }
                }
            }
        }
        return true; // If no conflicts, the graph is bipartite
    }
}
