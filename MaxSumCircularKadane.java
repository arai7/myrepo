class Solution {
   
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = kadane(nums);  // Maximum subarray sum (non-circular)
        
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];  // Invert the elements to find the minimum subarray sum using Kadane
        }
        
        int minSum = kadane(nums);  // Minimum subarray sum (inverted, so use Kadane's again)
        minSum = -minSum;  // Revert the inversion to get the actual minimum sum
        
        // If all numbers are negative, totalSum - minSum will be 0, which is not a valid subarray
        if (totalSum == minSum) {
            return maxSum;
        }
        
        // The maximum circular subarray sum will be the maximum of:
        // 1. The max non-circular subarray sum
        // 2. The max circular subarray sum, which is totalSum - minSum
        return Math.max(maxSum, totalSum - minSum);
    }
    
    private int kadane(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
