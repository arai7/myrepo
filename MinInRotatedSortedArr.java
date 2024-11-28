class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int i = 0, j = n-1;
        if(nums[i] < nums[j])
            return nums[0];

        int mid = 0;

        while(i <= j)
        {
            
            if(nums[i] < nums[j])
                return nums[i];
            mid = (i+j)/2;
            
            if(nums[i]==nums[mid])
                return Math.min(nums[i], nums[j]);
            
            if(nums[i]>nums[mid])
                j = mid;
            else
                i = mid+1;
        }
        return -1;

    }
}
