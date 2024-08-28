class Solution {
    
    public int maxSubArray(int[] nums) {
        // Initialize currentSum and maxSum with the first element of the array
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentSum by either adding the current element or starting a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum if currentSum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
