class Point {
    public int row, col, steps;

    public Point(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(entrance[0], entrance[1], 0));

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Mark the entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {  // ✅ Fix: use isEmpty()
            Point current = queue.poll();
            int currRow = current.row;
            int currCol = current.col;
            int currSteps = current.steps;

            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                // If it's out of bounds or a wall, skip
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || maze[nextRow][nextCol] != '.') {
                    continue;
                }

                // If it's an edge and not the entrance, return the steps
                if (isEdge(nextRow, nextCol, m, n) && !(nextRow == entrance[0] && nextCol == entrance[1])) {
                    return currSteps + 1;
                }

                // Mark as visited and add to the queue
                maze[nextRow][nextCol] = '+';
                queue.add(new Point(nextRow, nextCol, currSteps + 1));
            }
        }

        return -1;  // No exit found
    }

    public boolean isEdge(int row, int col, int m, int n) {
        return row == 0 || col == 0 || row == m - 1 || col == n - 1;
    }
}
