class Solution {
    public int closedIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            dfs(grid, i, 0);
            dfs(grid, i, cols-1);
        }
        for(int j = 0; j < cols; j++){
            dfs(grid, 0, j);
            dfs(grid, rows-1, j);
        }
        int res = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    res++;
                    dfs(grid, i , j);
                }
            }
        }
        return res;

    }

    public void dfs(int[][] grid, int x, int y){
        int rows = grid.length;
        int cols = grid[0].length;

        if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 0){
            return;
        }

        grid[x][y] = 1;

        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);

    }
}
