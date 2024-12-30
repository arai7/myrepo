class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // Rob either:
        // 1. Houses from 0 to n-2 (excluding last house)
        // 2. Houses from 1 to n-1 (excluding first house)
        return Math.max(
            robRange(nums, 0, nums.length - 2, new Integer[nums.length]),
            robRange(nums, 1, nums.length - 1, new Integer[nums.length])
        );
    }
    
    private int robRange(int[] nums, int start, int end, Integer[] memo) {
        // Base cases
        if (start > end) return 0;
        if (start == end) return nums[start];
        
        // Check if already computed
        if (memo[start] != null) return memo[start];
        
        // At each house, we can either:
        // 1. Rob this house and skip next house
        // 2. Skip this house and move to next house
        int robCurrent = nums[start] + robRange(nums, start + 2, end, memo);
        int skipCurrent = robRange(nums, start + 1, end, memo);
        
        // Store result in memo before returning
        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}
