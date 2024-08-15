class Solution {
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark the non-surrounded regions
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0); // Left border
            dfs(board, i, cols - 1); // Right border
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j); // Top border
            dfs(board, rows - 1, j); // Bottom border
        }

        // Step 2: Transform the surrounded regions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded 'O' cells to 'X'
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Non-surrounded 'O' cells back to 'O'
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary checks
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        // Mark the cell as 'T' to indicate it's not surrounded
        board[i][j] = 'T';

        // Explore all 4 possible directions
        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }
}
