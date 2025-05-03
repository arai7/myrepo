class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(0, nums, memo);
    }

    public int robHelper(int i, int[] nums, int[] memo){
        if(i >= nums.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int res = Math.max((nums[i] + robHelper(i+2, nums, memo)), robHelper(i+1, nums, memo));
        memo[i] = res;
        return res;
    }
}
