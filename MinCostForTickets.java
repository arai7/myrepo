class Solution {

    // Variables to hold ticket costs and memoization table
    private int[] costs;
    private int[] days;
    private int[] memo;
    
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.memo = new int[days.length]; // Memoization array
        Arrays.fill(memo, -1); // Fill memo with -1 to indicate uncomputed results
        
        // Start recursion from the first day
        return dp(0);
    }

    // Recursive function to calculate the minimum cost starting from day `i`
    private int dp(int i) {
        // Base case: No more days to cover
        if (i >= days.length) {
            return 0;
        }

        // If we have already computed the result for this day, return it
        if (memo[i] != -1) {
            return memo[i];
        }

        // Option 1: Buy a 1-day ticket
        int cost1 = costs[0] + dp(i + 1);

        // Option 2: Buy a 7-day ticket and skip the next 6 days
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int cost7 = costs[1] + dp(j);

        // Option 3: Buy a 30-day ticket and skip the next 29 days
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int cost30 = costs[2] + dp(j);

        // Take the minimum cost of the three options and store in memo
        memo[i] = Math.min(cost1, Math.min(cost7, cost30));
        
        return memo[i]; // Return the minimum cost for day `i`
    }
}
