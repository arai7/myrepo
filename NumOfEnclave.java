class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // 1. Flood-fill from the edges
        for(int i = 0; i < rows; i++) {
            dfs(grid, i, 0);         // Left edge
            dfs(grid, i, cols - 1);  // Right edge
        }

        for(int j = 0; j < cols; j++) {
            dfs(grid, 0, j);         // Top edge
            dfs(grid, rows - 1, j);  // Bottom edge
        }

        // 2. Count remaining 1s (enclaves)
        int res = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1){
            return;
        }

        grid[i][j] = 0; // Mark as visited (or 7 if you prefer, but 0 saves scan effort)

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
