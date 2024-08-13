class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        // Initialize arrays to keep track of the numbers in rows, columns, and sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Iterate over every cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Skip empty cells
                if (board[i][j] == '.') {
                    continue;
                }

                // Calculate the digit value (0-based index)
                int num = board[i][j] - '1';
                
                // Calculate the index for the 3x3 sub-box
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number has already been seen in the current row, column, or sub-box
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark the number as seen in the current row, column, and sub-box
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        // If no conflicts were found, the board is valid
        return true;
    }
}
