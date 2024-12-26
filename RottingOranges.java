import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        // Add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j}); // Add rotten orange
                if (grid[i][j] == 1) fresh++; // Count fresh orange
            }
        }

        // Directions to move: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS: Spread rot to adjacent fresh oranges
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            time++; // Increment time for each layer of BFS

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0], y = current[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; // Rot the fresh orange
                        queue.offer(new int[]{x, y}); // Add it to the queue
                        fresh--; // Decrease the fresh count
                    }
                }
            }
        }

        // If there are fresh oranges left, return -1. Otherwise, return the time.
        return fresh == 0 ? time : -1;
    }
}
