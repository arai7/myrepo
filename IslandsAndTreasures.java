import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] shortestDistanceFromTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[rows][cols];

        // Initialize queue with all treasure locations and mark visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // Add treasure locations
                } else {
                    distance[i][j] = -1; // Mark as unvisited for empty land
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Perform BFS
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++; // Increment steps for the next layer of BFS

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check bounds and if the cell is unvisited
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && distance[newX][newY] == -1) {
                        distance[newX][newY] = steps; // Update the distance
                        queue.offer(new int[]{newX, newY}); // Add to queue
                    }
                }
            }
        }

        return distance;
    }
}
