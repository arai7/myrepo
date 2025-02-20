import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1]; // Adjacency list (1-based index)
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Convert dislikes pairs into an adjacency list
        for (int[] pair : dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        int[] colors = new int[n + 1]; // 0 = unvisited, 1 = red, -1 = blue

        for (int i = 1; i <= n; i++) {
            if (colors[i] != 0) continue; // Already colored

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) { // Not colored, assign opposite color
                        colors[neighbor] = -colors[node];
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[node]) { // Conflict found
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
