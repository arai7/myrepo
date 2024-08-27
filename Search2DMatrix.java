class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        
        int m = matrix.length, n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while(start <= end){
            int  middle = (start + end) / 2;
            int row = middle / n;
            int col = middle % n;
            int value = matrix[row][col];
            if(value == target) return true;
            if(value < target) start = middle + 1;
            else end = middle - 1;
        }

        return false;
    }
}
