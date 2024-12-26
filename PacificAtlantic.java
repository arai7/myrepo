class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length, cols = heights[0].length;

        // Matrices to track reachability
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Start DFS from the edges
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacificReachable, Integer.MIN_VALUE); // Top edge (Pacific)
            dfs(heights, rows - 1, col, atlanticReachable, Integer.MIN_VALUE); // Bottom edge (Atlantic)
        }
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacificReachable, Integer.MIN_VALUE); // Left edge (Pacific)
            dfs(heights, row, cols - 1, atlanticReachable, Integer.MIN_VALUE); // Right edge (Atlantic)
        }

        // Collect cells reachable by both oceans
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacificReachable[row][col] && atlanticReachable[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] reachable, int prevHeight) {
        // Base conditions for DFS
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return;
        if (reachable[row][col] || heights[row][col] < prevHeight) return;

        // Mark as reachable
        reachable[row][col] = true;

        // Explore in all 4 directions
        dfs(heights, row + 1, col, reachable, heights[row][col]); // Down
        dfs(heights, row - 1, col, reachable, heights[row][col]); // Up
        dfs(heights, row, col + 1, reachable, heights[row][col]); // Right
        dfs(heights, row, col - 1, reachable, heights[row][col]); // Left
    }
}
