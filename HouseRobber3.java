class Solution {
    public int rob(int[] nums) {
        // Edge case: No houses to rob
        if (nums == null || nums.length == 0) return 0;

        // Memoization array
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        // Start robbing from the first house
        return robFrom(0, nums, dp);
    }

    private int robFrom(int i, int[] nums, int[] dp) {
        // Base case: No more houses left to rob
        if (i >= nums.length) return 0;

        // If already computed, return the result
        if (dp[i] != -1) return dp[i];

        // Choice 1: Rob current house and move to i+2
        int rob = nums[i] + robFrom(i + 2, nums, dp);

        // Choice 2: Skip current house and move to i+1
        int skip = robFrom(i + 1, nums, dp);

        // Store the result in dp array and return the max
        dp[i] = Math.max(rob, skip);
        return dp[i];
    }
}
