class Solution {
    int n = 0;
    int m = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;  // Assign to instance variables
        m = image[0].length;
        int originalColor = image[sr][sc];

        // Avoid infinite recursion if the starting pixel is already the target color
        if (originalColor != color) {
            dfs(image, sr, sc, color, originalColor);
        }
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int originalColor) {
        if (i < 0 || i >= n || j < 0 || j >= m || image[i][j] != originalColor) {
            return;
        }

        image[i][j] = color;
        dfs(image, i + 1, j, color, originalColor);
        dfs(image, i - 1, j, color, originalColor);
        dfs(image, i, j + 1, color, originalColor);
        dfs(image, i, j - 1, color, originalColor);
    }
}
