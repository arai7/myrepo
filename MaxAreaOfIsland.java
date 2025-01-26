class Solution 
{
    int rows = 0;
    int cols = 0;
    public int maxAreaOfIsland(int[][] grid) 
    {
        if(grid == null || grid.length==0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        
        int maxArea = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j)
    {
        if(i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j]==0)
            return 0;

        grid[i][j] = 0;

        return 1+dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
    }
}
