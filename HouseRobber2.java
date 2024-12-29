class Solution {
    public int robEarning(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int profit = nums[i] + robEarning(nums, i + 2, dp);
        int skip = robEarning(nums, i + 1, dp);
        dp[i] = Math.max(profit, skip);
        return dp[i];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return Math.max(robEarning(nums, 0, dp), robEarning(nums, 1, dp));
    }
}
