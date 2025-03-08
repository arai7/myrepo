class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOpWindow = k; // Max possible operations needed
        int blackCount = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
        }

        minOpWindow = k - blackCount; // Minimum recolors needed

        // Slide the window
        for (int i = k; i < blocks.length(); i++) {
            // Add new character coming in
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
            // Remove the character going out
            if (blocks.charAt(i - k) == 'B') {
                blackCount--;
            }

            minOpWindow = Math.min(minOpWindow, k - blackCount);
        }

        return minOpWindow;
    }
}
