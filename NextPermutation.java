class Solution {
    public void nextPermutation(int[] nums) 
    {
        int n = nums.length;
        if (n <= 1) return; // No next permutation if array is of length 1 or less

        // Step 1: Find the first decreasing element from the right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) 
        {
            i--;
        }

        // Step 2: If we found a decreasing element
        if (i >= 0) 
        {
            // Find the next largest element on the right side of nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) 
            {
                j--;
            }
            // Swap the elements
            swap(nums, i, j);
        }

        // Step 3: Reverse the part of the array from i + 1 to the end
        reverse(nums, i + 1, n - 1);
    }

    // Helper function to swap two elements in the array
    private void swap(int[] nums, int i, int j) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse the array from start to end
    private void reverse(int[] nums, int start, int end) 
    {
        while (start < end) 
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
