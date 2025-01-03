class Solution 
{
    public int waysToSplitArray(int[] nums) 
    {
        int n = nums.length;
        long[] prefixSum = new long[n];
        long prevSum =0;
        for(int i = 0; i<n; i++)
        {
            prevSum += nums[i];
            prefixSum[i] = prevSum;
        }
        long max = prefixSum[n-1];
        int splitCount = 0;
        for(int i = 0; i< n-1; i++)
        {
            if(max - prefixSum[i] <= prefixSum[i])
            {
                splitCount++;
            }
        }
        return splitCount;
    }
}
