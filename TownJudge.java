class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1; // If there's only one person, they're the judge.

        int[] trustCount = new int[n + 1]; // Trust balance for each person.

        for (int[] t : trust) {
            trustCount[t[0]]--; // Outgoing trust → Decrease count
            trustCount[t[1]]++; // Incoming trust → Increase count
        }

        // The judge should have trustCount[n] == n-1
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1; // No judge found
    }
}
