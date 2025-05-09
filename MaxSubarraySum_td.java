class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);

        for(int i = 0; i < n; i++){
            res = Math.max(res, dfs(nums, i, memo));
        }

        return res;
    }

    private int dfs(int[] nums, int i, int[] memo){
        if(i == 0){
            return nums[0];
        }

        if(memo[i] != Integer.MIN_VALUE){
            return memo[i];
        }

        memo[i] =  Math.max(nums[i], dfs(nums, i-1, memo) + nums[i]);
        return memo[i];
    }
}
