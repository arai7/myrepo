class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // If there's only one step, the minimum cost is the cost of that step.
        if (n == 1) return cost[0];
        
        // Two variables to track the minimum cost of the last two steps.
        int prev2 = 0; // Cost to reach two steps before.
        int prev1 = 0; // Cost to reach one step before.

        // Iterate through the cost array and calculate the minimum cost dynamically.
        for (int i = 0; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        // Return the minimum cost to reach the top (either from the last step or second-to-last step).
        return Math.min(prev1, prev2);
    }
}
