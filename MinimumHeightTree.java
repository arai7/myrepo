import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0); // Edge case for single node
        
        // Step 1: Build Graph and In-Degree Array
        List<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            inDegree[u]++;
            inDegree[v]++;
        }
        
        // Step 2: Find Initial Leaves (Nodes with inDegree == 1)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }
        
        // Step 3: Remove Leaves Layer by Layer
        int remainingNodes = n;
        while (remainingNodes > 2) {  // Stop when <= 2 nodes remain
            int size = queue.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                for (int neighbor : graph[leaf]) {
                    inDegree[neighbor]--;  // Reduce neighbor's degree
                    if (inDegree[neighbor] == 1) {
                        queue.offer(neighbor);  // It becomes a new leaf
                    }
                }
            }
        }
        
        // Step 4: Return the Last Remaining Nodes (Roots of MHTs)
        return new ArrayList<>(queue);
    }
}
