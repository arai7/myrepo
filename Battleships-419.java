class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int battleship = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'X'){
                    int left = j - 1;
                    int up = i - 1; 
                    Boolean checkLeft = true;
                    Boolean checkUp = true;

                    if(left >= 0){
                        if(board[i][left] == 'X'){
                            checkLeft = false;
                        }
                    }

                    if(up >= 0){
                        if(board[up][j] == 'X'){
                            checkUp = false;
                        }
                    }
                    if(checkLeft && checkUp){
                        battleship++;
                    }
                }
            }
        }

        return battleship;
    }
}
