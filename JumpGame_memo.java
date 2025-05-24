class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return recursive(nums, 0, memo);
    }

    public boolean recursive(int[] nums, int curr, int[] memo) {
        if (curr >= nums.length - 1) {
            return true;
        }

        if (memo[curr] != -1) {
            return memo[curr] == 1;
        }

        int range = nums[curr];
        for (int i = range; i >= 1; i--) {
            if (recursive(nums, curr + i, memo)) {
                memo[curr] = 1;
                return true;
            }
        }

        memo[curr] = 0;
        return false;
    }
}
