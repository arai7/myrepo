import java.util.*;

class Solution {
    public void wallsAndGates(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add all gates (0s) to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS from all gates
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new cell is valid and unvisited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol});   // Add the cell to the queue
                }
            }
        }
    }
}
