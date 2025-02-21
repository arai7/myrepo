class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo, m, n));
            }
        }
        return res;
    }

    public int dfs(int row, int col, int[][] matrix, int[][] memo, int m, int n) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxPath = 1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n &&
                matrix[nextRow][nextCol] > matrix[row][col]) {
                maxPath = Math.max(maxPath, 1 + dfs(nextRow, nextCol, matrix, memo, m, n));
            }
        }

        memo[row][col] = maxPath;  // Memoization step AFTER processing all directions
        return maxPath;
    }
}
